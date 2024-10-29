package com.abel.spzxmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abel.spzxmanager.service.SysUserService;
import com.abel.spzxmodel.dto.system.LoginDto;
import com.abel.spzxmodel.vo.common.Result;
import com.abel.spzxmodel.vo.system.LoginVo;
import com.abel.spzxmodel.vo.system.UserInfoVo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/system/index")
@Slf4j
public class IndexController {

    @Autowired
    SysUserService sysUserService;

    // 健康检查
    @GetMapping("/health")
    public Result<String> health() {
        return Result.success("ok");
    }

    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody @NonNull LoginDto loginDto, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        log.info("登录IP: {}", ip);
        LoginVo login = sysUserService.login(loginDto);
        if (login == null) {
            return Result.fail("用户名或密码错误");
        }
        return Result.success(login);
    }

    @GetMapping("/userinfo")
    public Result<UserInfoVo> getUserInfo(@RequestParam("token") @NonNull String token) {
        UserInfoVo userInfo = sysUserService.getUserInfo(token);
        
        return Result.success(userInfo);
    }
    
}
