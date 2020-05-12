package com.logexample.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年04月26日 11:07:00
 */
@RestController
@RequestMapping("user")
public class UserController {


    @GetMapping("/hello")
    public String  helloWorld() {
        System.out.println("Hello~");
        return "hello!";
    }
}

