package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年04月01日 11:05:00
 */
@RequestMapping(value = "/pk")
@RestController
public class UserController   {
    @Autowired
    private IUserService userService;

    @GetMapping("/pk/getUser/{id}")
    @ResponseBody
    public User getUserById(String id) {
        return userService.getById(id);
    }
    @DeleteMapping("/pk/deleteUser/{id}")
    @ResponseBody
    public boolean deleteUserById(String id) {
        return userService.removeById(id);
    }
    @PostMapping("/pk/getUserList/")
    @ResponseBody
    public List<User> getUserList() {
        return userService.list();
    }
    @DeleteMapping("/pk/insertUserById/{id}")
    @ResponseBody
    public boolean insertUserById(User user) {
        return userService.save(user);
    }
}
