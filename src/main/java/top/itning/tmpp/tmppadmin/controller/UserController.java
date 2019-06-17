package top.itning.tmpp.tmppadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.itning.tmpp.tmppadmin.pojo.AdminUser;
import top.itning.tmpp.tmppadmin.pojo.AdminUserRole;
import top.itning.tmpp.tmppadmin.service.AdminUserRoleService;
import top.itning.tmpp.tmppadmin.service.AdminUserService;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 18:03
 */
@Controller
public class UserController {
    private final AdminUserService adminUserService;
    private final AdminUserRoleService adminUserRoleService;

    @Autowired
    public UserController(AdminUserService adminUserService, AdminUserRoleService adminUserRoleService) {
        this.adminUserService = adminUserService;
        this.adminUserRoleService = adminUserRoleService;
    }

    /**
     * 获取所有用户
     *
     * @param model {@link Model}
     * @return user.html
     */
    @GetMapping("/user")
    public String user(Model model) {
        List<AdminUser> adminUsers = adminUserService.getAdminUsers();
        model.addAttribute("adminUsers", adminUsers);
        return "user";
    }

    /**
     * 添加用户页面
     *
     * @param model {@link Model}
     * @return addUser.html
     */
    @GetMapping("/addUser")
    public String addUser(Model model) {
        List<AdminUserRole> allAdminUserRoleList = adminUserRoleService.getAdminUserRoles();
        model.addAttribute("allAdminUserRoleList", allAdminUserRoleList);
        return "addUser";
    }

    /**
     * 添加用户
     *
     * @param name     昵称
     * @param username 登录ID
     * @param type     角色
     * @return user.html
     */
    @PostMapping("/addUser")
    public String handleAddUser(@RequestParam String name, @RequestParam String username, @RequestParam String type) {
        adminUserService.addAdminUser(name, username, type);
        return "redirect:user";
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return user.html
     */
    @GetMapping("delUser")
    public String delUser(@RequestParam String id) {
        adminUserService.delAdminUserById(id);
        return "redirect:user";
    }
}
