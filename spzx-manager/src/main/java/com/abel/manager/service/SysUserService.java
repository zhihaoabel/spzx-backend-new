package com.abel.manager.service;

import com.abel.manager.page.PageVo;
import com.abel.model.dto.system.LoginDto;
import com.abel.model.dto.system.user.UserQueryDto;
import com.abel.model.vo.system.LoginVo;
import com.abel.model.vo.system.UserInfoVo;
import com.abel.model.vo.system.UserVo;

public interface SysUserService {

    /**
     * 根据用户名和密码登录
     *
     * @param loginDto 登录信息
     * @return 登录结果
     */
    LoginVo login(LoginDto loginDto);

    UserInfoVo getUserInfo(String token);

    void logout(String token);

    PageVo<UserVo> findByPage(UserQueryDto queryDto);

}
