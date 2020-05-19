package com.betty.lesson.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2020年05月19日 16:35:00
 */
@Controller
//@RestController
public class IndexController {
    @GetMapping("index")
    public String index() {
        return "index";
    }
}
