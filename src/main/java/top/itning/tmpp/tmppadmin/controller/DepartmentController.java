package top.itning.tmpp.tmppadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.itning.tmpp.tmppadmin.pojo.Department;
import top.itning.tmpp.tmppadmin.service.DepartmentService;

import java.util.List;

/**
 * 授课部门
 *
 * @author itning
 * @date 2019/6/18 12:42
 */
@Controller
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 授课部门页面
     *
     * @param model {@link Model}
     * @return department.html
     */
    @GetMapping("/department")
    public String department(Model model) {
        List<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("departments", departments);
        return "department";
    }

    /**
     * 保存授课部门页面
     *
     * @return saveDepartment.html
     */
    @GetMapping("addDepartment")
    public String saveDepartment() {
        return "addDepartment";
    }

    /**
     * 保存授课部门
     *
     * @param name 授课部门名
     * @return department.html
     */
    @PostMapping("addDepartment")
    public String handleSaveDepartment(@RequestParam String name) {
        departmentService.saveDepartment(name);
        return "redirect:department";
    }

    /**
     * 更新授课部门页面
     *
     * @param id    授课部门id
     * @param model {@link Model}
     * @return upDepartment.html
     */
    @GetMapping("upDepartment")
    public String upDepartment(@RequestParam String id, Model model) {
        Department department = departmentService.getDepartment(id);
        if (department == null) {
            model.addAttribute("error", "授课部门ID:" + id + "不存在");
            return "error";
        }
        model.addAttribute("department", department);
        return "upDepartment";
    }

    /**
     * 更新授课部门
     *
     * @param id   授课部门ID
     * @param name 授课部门名
     * @return department.html
     */
    @PostMapping("upDepartment")
    public String handleUpDepartment(@RequestParam String id, @RequestParam String name) {
        departmentService.upDepartment(id, name);
        return "redirect:department";
    }

    /**
     * 删除授课部门
     *
     * @param id 授课部门ID
     * @return department.html
     */
    @GetMapping("delDepartment")
    public String delDepartment(@RequestParam String id) {
        departmentService.delDepartment(id);
        return "redirect:department";
    }
}
