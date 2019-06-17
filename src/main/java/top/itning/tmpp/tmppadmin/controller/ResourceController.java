package top.itning.tmpp.tmppadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.itning.tmpp.tmppadmin.pojo.AdminResource;
import top.itning.tmpp.tmppadmin.pojo.AdminUserRole;
import top.itning.tmpp.tmppadmin.service.AdminResourceService;
import top.itning.tmpp.tmppadmin.service.AdminUserRoleService;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 14:53
 */
@Controller
public class ResourceController {
    private final AdminResourceService adminResourceService;
    private final AdminUserRoleService adminUserRoleService;

    @Autowired
    public ResourceController(AdminResourceService adminResourceService, AdminUserRoleService adminUserRoleService) {
        this.adminResourceService = adminResourceService;
        this.adminUserRoleService = adminUserRoleService;
    }

    /**
     * 资源
     *
     * @return resource.html
     */
    @GetMapping("/resource")
    public String resource(Model model) {
        model.addAttribute("adminResources", adminResourceService.getAllAdminResources());
        return "resource";
    }

    /**
     * 添加资源页面
     *
     * @return addResource.html
     */
    @GetMapping("/addResource")
    public String addResource(Model model) {
        List<AdminUserRole> allAdminUserRoleList = adminUserRoleService.getAdminUserRoles();
        model.addAttribute("allAdminUserRoleList", allAdminUserRoleList);
        return "addResource";
    }

    /**
     * 添加资源
     *
     * @param url    资源
     * @param method 方法
     * @return resource.html
     */
    @PostMapping("/addResource")
    public String handleAddResource(@RequestParam String url, @RequestParam String method, @RequestParam int[] roles) {
        adminResourceService.saveAdminResource(url, method,roles);
        return "redirect:resource";
    }

    /**
     * 更新资源页面
     *
     * @param id    要更新的ID
     * @param model {@link Model}
     * @return upResource.html
     */
    @GetMapping("/upResource")
    public String upResource(@RequestParam String id, Model model) {
        AdminResource adminResource = adminResourceService.getAdminResourceById(id);
        if (adminResource == null) {
            model.addAttribute("error", "resource id " + id + " not found");
            return "error";
        }
        List<AdminUserRole> adminUserRoleList = adminUserRoleService.getAdminUserRoleByResourceId(id);
        List<AdminUserRole> allAdminUserRoleList = adminUserRoleService.getAdminUserRoles();
        model.addAttribute("allAdminUserRoleList", allAdminUserRoleList);
        model.addAttribute("adminUserRoleList", adminUserRoleList);
        model.addAttribute("adminResource", adminResource);
        return "upResource";
    }

    /**
     * 更新资源
     *
     * @param id     资源ID
     * @param url    新URL
     * @param method 新方法
     * @param roles  角色ID
     * @return resource.html
     */
    @PostMapping("/upResource")
    public String handleUpResource(@RequestParam String id,
                                   @RequestParam String url,
                                   @RequestParam String method,
                                   @RequestParam int[] roles) {
        adminResourceService.upAdminResource(id, url, method, roles);
        return "redirect:resource";
    }

    /**
     * 删除资源
     *
     * @param id 资源ID
     * @return resource.html
     */
    @GetMapping("/delResource")
    public String delResource(@RequestParam String id) {
        adminResourceService.delAdminResource(id);
        return "redirect:resource";
    }
}
