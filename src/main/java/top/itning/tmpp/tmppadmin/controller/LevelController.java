package top.itning.tmpp.tmppadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.itning.tmpp.tmppadmin.pojo.Level;
import top.itning.tmpp.tmppadmin.service.LevelService;

import java.util.List;

/**
 * 层次
 *
 * @author itning
 * @date 2019/6/18 12:42
 */
@Controller
public class LevelController {
    private final LevelService levelService;

    @Autowired
    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    /**
     * 层次
     *
     * @param model {@link Model}
     * @return level.html
     */
    @GetMapping("/level")
    public String level(Model model) {
        List<Level> levels = levelService.getAllLevel();
        model.addAttribute("levels", levels);
        return "level";
    }

    /**
     * 添加层次页面
     *
     * @return addLevel.html
     */
    @GetMapping("/addLevel")
    public String addLevel() {
        return "addLevel";
    }

    /**
     * 添加层次
     *
     * @param educationalLevel 层次
     * @return addLevel.html
     */
    @PostMapping("/addLevel")
    public String handleAddLevel(@RequestParam String educationalLevel) {
        levelService.saveLevel(educationalLevel);
        return "redirect:level";
    }

    /**
     * 修改层次页面
     *
     * @param id    层次ID
     * @param model {@link Model}
     * @return upLevel.html
     */
    @GetMapping("/upLevel")
    public String upLevel(@RequestParam String id, Model model) {
        Level level = levelService.getLevel(id);
        if (level == null) {
            model.addAttribute("error", "层次ID:" + id + "不存在");
            return "error";
        }
        model.addAttribute("level", level);
        return "upLevel";
    }

    /**
     * 修改层次
     *
     * @param id               层次ID
     * @param educationalLevel 层次
     * @return upLevel.html
     */
    @PostMapping("/upLevel")
    public String handleUpLevel(@RequestParam String id, @RequestParam String educationalLevel) {
        levelService.upLevel(id, educationalLevel);
        return "redirect:level";
    }

    /**
     * 删除层次
     *
     * @param id 层次ID
     * @return upLevel.html
     */
    @GetMapping("/delLevel")
    public String delLevel(@RequestParam String id) {
        levelService.delLevel(id);
        return "redirect:level";
    }
}
