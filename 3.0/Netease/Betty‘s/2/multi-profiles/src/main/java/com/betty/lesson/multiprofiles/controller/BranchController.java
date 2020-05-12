package com.betty.lesson.multiprofiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName BranchController.java
 * @Description TODO
 * @createTime 2020年05月07日 11:42:00
 */
@RestController
@RequestMapping("/controller")
public class BranchController {
    @Value("${branch}")
    private String branch;
    @GetMapping("/branch")
    @ResponseBody
    public String getBranch() {
        return "Current Branch is " + branch;
    }
}
