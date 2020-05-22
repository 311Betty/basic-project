package com.betty.lesson.service.impl;

import com.betty.lesson.entity.SysUser;
import com.betty.lesson.mapper.SysUserMapper;
import com.betty.lesson.service.UserService;
import com.betty.lesson.utils.PasswordUtils;
import com.betty.lesson.vo.req.RegisterReqVO;
import com.betty.lesson.vo.req.UpdateUserReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年05月21日 15:07:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserInfo(String id) {
        System.out.println("=========" + id);
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public String register(RegisterReqVO vo) {
        //获得实体
        SysUser sysUser = new SysUser();
        //复制相同属性
        BeanUtils.copyProperties(vo, sysUser);
        //set盐 密码 id 时间
        sysUser.setSalt(PasswordUtils.getSalt());
        String encode = PasswordUtils.encode(vo.getPassword(), sysUser.getSalt());
        sysUser.setPassword(encode);
        sysUser.setCreateTime(new Date());
        //(⊙o⊙)…id
        sysUser.setId(UUID.randomUUID().toString());
        //插入数据库
        int i = sysUserMapper.insertSelective(sysUser);
        if (i != 1) {
            return "注册失败";
        }
        return "注册成功";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateUserInfo(UpdateUserReqVO vo) {
        //获得实体
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(vo.getId());
        //判空
        if (sysUser == null) {
            return "操作失败";
        }

        //复制属性
        BeanUtils.copyProperties(vo,sysUser);
        // 更新
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        //判断更新是否成功
        if (i != 1) {
            return "操作失败";
        }
        //做一个exception
        int count=1/0;
        return "操作成功";

    }

    @Override
    public String deleteUserInfo(String id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setDeleted(1);
        sysUser.setUpdateTime(new Date());
        //用update做删除操作
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i == 0) {
            return "操作失败";
        }

        return "操作成功";
    }
}
