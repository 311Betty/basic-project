package com.betty.lesson.myinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName InterceptorController.java
 * @Description TODO
 * @createTime 2020年05月19日 15:30:00
 */
@RestController
@RequestMapping("/api/")
public class InterceptorController {
    @GetMapping("/home/open/info")
    public String hello() {
        return "欢迎来到首页";
    }

    @GetMapping("user/list")
    public String list() {
        return "我被拦截，并通过了拦截器";

    }

    @GetMapping("/open/unlogin")
    public String unlogin() {
        return "登录失效";
    }
}
