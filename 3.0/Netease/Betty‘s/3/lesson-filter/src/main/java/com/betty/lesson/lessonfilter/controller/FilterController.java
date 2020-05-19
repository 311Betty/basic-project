package com.betty.lesson.lessonfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName FilterController.java
 * @Description TODO
 * @createTime 2020年05月18日 14:51:00
 */
@RestController
@RequestMapping("/api/")
public class FilterController {
    @GetMapping("/user/filter")
    public String hello() {
        return "通过了过滤器";
    }

    //首页
    @GetMapping("/open/main")
    public Map<String, String> main() {
        Map<String, String> map = new HashMap<>();
        map.put("游客", "欢迎进入首页");
        return map;
    }

    //未登录/失效
    @GetMapping("/open/unlogin")
    public String getunlogin() {
        return "登录失效";
    }
}
