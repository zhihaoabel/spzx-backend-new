package com.abel.spzxmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abel.spzxmanager.service.SysUserService;
import com.abel.spzxmodel.dto.system.LoginDto;
import com.abel.spzxmodel.vo.common.Result;
import com.abel.spzxmodel.vo.system.LoginVo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController("/admin/system/index")
@Slf4j
public class IndexController {

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        log.info("登录IP: {}", ip);
        LoginVo login = sysUserService.login(loginDto);
        return Result.success(login);
    }
}
