package com.betty.lesson.service;

import com.betty.lesson.entity.SysUser;
import com.betty.lesson.vo.req.RegisterReqVO;
import com.betty.lesson.vo.req.UpdateUserReqVO;

public interface UserService {
    SysUser getUserInfo(String id);

    String register(RegisterReqVO vo);

    String updateUserInfo(UpdateUserReqVO vo);

    String deleteUserInfo(String id);
}
