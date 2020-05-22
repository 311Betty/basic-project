package com.betty.lesson.controller;

import com.betty.lesson.entity.SysUser;
import com.betty.lesson.service.UserService;
import com.betty.lesson.vo.req.RegisterReqVO;
import com.betty.lesson.vo.req.UpdateUserReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年05月21日 15:09:00
 */
@RestController
@RequestMapping("/sys")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/getUser")
    public SysUser getUserInfo(@RequestParam String id) {
        return userService.getUserInfo(id);
    }

    @GetMapping("/users/{id}")
    public SysUser getUserDetail(@PathVariable("id") String id) {
        return userService.getUserInfo(id);
    }

    @PostMapping("/users")
    public String register(@RequestBody RegisterReqVO vo) {
        return userService.register(vo);
    }

    @PutMapping("/users")
    public String updateUserInfo(@RequestBody UpdateUserReqVO vo) {
        return userService.updateUserInfo(vo);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserInfo(@PathVariable("id") String id) {
        return userService.deleteUserInfo(id);
    }


}

