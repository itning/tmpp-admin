package top.itning.tmpp.tmppadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author itning
 * @date 2019/6/17 14:53
 */
@Controller
public class FrameController {

    /**
     * 主页
     *
     * @return index.html
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
