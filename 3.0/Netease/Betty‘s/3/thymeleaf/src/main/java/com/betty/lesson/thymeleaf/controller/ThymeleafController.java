package com.betty.lesson.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName ThymeleafController.java
 * @Description TODO
 * @createTime 2020年05月19日 17:05:00
 */
@Controller
@RequestMapping("/user/")
public class ThymeleafController {
    @GetMapping("/test")
    public String hello(Model model) {
        model.addAttribute("username", "张三");
        return "index";
    }
}
