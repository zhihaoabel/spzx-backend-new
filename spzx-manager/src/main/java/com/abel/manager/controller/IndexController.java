package com.abel.manager.controller;

import com.abel.common.service.log.Logs;
import com.abel.manager.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.abel.model.dto.system.LoginDto;
import com.abel.common.service.response.Result;
import com.abel.model.vo.system.LoginVo;
import com.abel.model.vo.system.UserInfoVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/system/index")
@Slf4j
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    // 健康检查
    @GetMapping("/health")
    public Result<String> health() {
        return Result.success("ok");
    }

    @Logs(value = "用户登录", printParams = true)
    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody @NonNull LoginDto loginDto) {
        LoginVo login = sysUserService.login(loginDto);
        if (login == null) {
            return Result.fail("用户名或密码错误");
        }
        return Result.success(login);
    }

    @Logs(value = "获取用户信息", printParams = false)
    @GetMapping("/userinfo")
    public Result<UserInfoVo> getUserInfo(@RequestHeader(name = "Authorization") @NonNull String authorization) {
        // authorization = Bearer xxxxx
        String token = authorization.substring(7);
        UserInfoVo userInfo = sysUserService.getUserInfo(token);

        return Result.success(userInfo);
    }

}