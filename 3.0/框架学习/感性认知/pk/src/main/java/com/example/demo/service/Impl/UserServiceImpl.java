package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName UserImpl.java
 * @Description TODO
 * @createTime 2020年04月01日 11:06:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

}
