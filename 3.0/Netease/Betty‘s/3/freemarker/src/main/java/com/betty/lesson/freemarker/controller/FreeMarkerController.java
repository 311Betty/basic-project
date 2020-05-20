package com.betty.lesson.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName FreeMarkerController.java
 * @Description TODO
 * @createTime 2020年05月19日 17:21:00
 */
@Controller
public class FreeMarkerController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("username", "张三");
        return "index";
    }
}
