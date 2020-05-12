package com.betty.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.betty.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"用户表接口"})

public interface IUserController {

    @ApiOperation(value = "根据Id查询用户", notes = "请输入用户ID")
    @GetMapping("/info/{id}")
    User getUser(@ApiParam(value = "id", required = true) @PathVariable("id") int id);

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/list")
    IPage getUserList(@ApiParam(value = "page", required = true) Page page);

    @ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
    @DeleteMapping("/remove/{id}")
    String removeUser(@ApiParam(value = "id", required = true, defaultValue = "1") @PathVariable("id") int id);

    @ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
    @PostMapping("/save")
    String saveUser(@ApiParam(value = "user", required = true) @RequestBody User user);

    @ApiOperation(value = "根据姓名模糊查询", notes = "请输入要模糊查询的信息")
    @GetMapping(value = {"/getUserByLikeName/{name}"})
    List<User> getUserByLikeName(@ApiParam(value = "name", required = true) @PathVariable String name);

}
