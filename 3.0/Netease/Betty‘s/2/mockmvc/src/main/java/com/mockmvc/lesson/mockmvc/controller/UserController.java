package com.mockmvc.lesson.mockmvc.controller;

import com.mockmvc.lesson.mockmvc.entity.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年05月09日 15:52:00
 */
@RestController
public class UserController {

    @GetMapping("/user")

    public UserInfo getUserInfo(@RequestParam(required = false) String name, String age) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setAge(age);
        return userInfo;
    }

    @PostMapping("/user")
    public UserInfo getUserInfo(@RequestBody(required = false) UserInfo userInfo) {
        System.out.println(userInfo.getName());
        return userInfo;
    }
}

