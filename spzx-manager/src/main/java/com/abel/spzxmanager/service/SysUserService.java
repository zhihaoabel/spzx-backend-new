package com.abel.spzxmanager.service;

import com.abel.spzxmodel.dto.system.LoginDto;
import com.abel.spzxmodel.vo.system.LoginVo;
import com.abel.spzxmodel.vo.system.UserInfoVo;

public interface SysUserService {

    /**
     * 根据用户名和密码登录
     *
     * @param loginDto
     * @return
     */
    LoginVo login(LoginDto loginDto);

    UserInfoVo getUserInfo(String token);

}
