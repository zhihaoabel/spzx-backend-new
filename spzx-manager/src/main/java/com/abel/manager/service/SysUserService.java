package com.abel.manager.service;

import com.abel.model.dto.system.LoginDto;
import com.abel.model.vo.system.LoginVo;
import com.abel.model.vo.system.UserInfoVo;

public interface SysUserService {

    /**
     * 根据用户名和密码登录
     *
     * @param loginDto 登录信息
     * @return 登录结果
     */
    LoginVo login(LoginDto loginDto);

    UserInfoVo getUserInfo(String token);

}
