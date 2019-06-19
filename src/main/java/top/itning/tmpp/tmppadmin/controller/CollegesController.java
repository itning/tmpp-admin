package top.itning.tmpp.tmppadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.itning.tmpp.tmppadmin.pojo.Colleges;
import top.itning.tmpp.tmppadmin.service.CollegesService;

import java.util.List;

/**
 * 学院
 *
 * @author itning
 * @date 2019/6/18 12:42
 */
@Controller
public class CollegesController {
    private final CollegesService collegesService;

    @Autowired
    public CollegesController(CollegesService collegesService) {
        this.collegesService = collegesService;
    }

    /**
     * 学院
     *
     * @param model {@link Model}
     * @return colleges.html
     */
    @GetMapping("/colleges")
    public String colleges(Model model) {
        List<Colleges> colleges = collegesService.getAllColleges();
        model.addAttribute("colleges", colleges);
        return "colleges";
    }

    /**
     * 添加学院页面
     *
     * @return addColleges.html
     */
    @GetMapping("/addColleges")
    public String addColleges() {
        return "addColleges";
    }

    /**
     * 添加学院
     *
     * @param name 学院名
     * @return colleges.html
     */
    @PostMapping("addColleges")
    public String handleAddColleges(@RequestParam String name) {
        collegesService.saveColleges(name);
        return "redirect:colleges";
    }

    /**
     * 修改学院页面
     *
     * @param id    学院ID
     * @param model {@link Model}
     * @return upColleges.html
     */
    @GetMapping("upColleges")
    public String upColleges(@RequestParam String id, Model model) {
        Colleges colleges = collegesService.getColleges(id);
        if (colleges == null) {
            model.addAttribute("error", colleges);
            return "error";
        }
        model.addAttribute("colleges", colleges);
        return "upColleges";
    }

    /**
     * 修改学院
     *
     * @param id   学院ID
     * @param name 学院名
     * @return colleges.html
     */
    @PostMapping("upColleges")
    public String upColleges(@RequestParam String id, @RequestParam String name) {
        collegesService.upColleges(id, name);
        return "redirect:colleges";
    }

    /**
     * 删除学员
     *
     * @param id 学院ID
     * @return colleges.html
     */
    @GetMapping("delColleges")
    public String delColleges(@RequestParam String id) {
        collegesService.delColleges(id);
        return "redirect:colleges";
    }
}
