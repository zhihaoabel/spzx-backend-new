package com.abel.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abel.common.service.log.Logs;
import com.abel.manager.service.SysUserService;
import com.abel.manager.service.impl.CaptchaService;
import com.abel.model.common.Result;
import com.abel.model.common.ResultCodeEnum;
import com.abel.model.dto.system.CaptchaDto;
import com.abel.model.dto.system.LoginDto;
import com.abel.model.utils.ContextUtil;
import com.abel.model.vo.system.CaptchaVo;
import com.abel.model.vo.system.LoginVo;
import com.abel.model.vo.system.UserInfoVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/system/index")
@Slf4j
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private CaptchaService captchaService;

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
    public Result<UserInfoVo> getUserInfo() {
        UserInfoVo userInfo = ContextUtil.getUser();
        return Result.success(userInfo);
    }

    @Logs(value = "生成验证码", printParams = false)
    @GetMapping("/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo captcha = captchaService.generateCaptcha();
        return Result.success(captcha);
    }

    @Logs(value = "验证验证码", printParams = true)
    @PostMapping("/validate-captcha")
    public Result<Boolean> validateCaptcha(@RequestBody @NonNull CaptchaDto captchaDto) {
        boolean isValid = captchaService.validateCaptcha(captchaDto);
        return Result.success(isValid);
    }

    @Logs(value = "退出登录", printParams = false)
    @PostMapping("/logout")
    public Result<String> logout(@RequestHeader(name = "Authorization") @NonNull String authorization) {
        String token = authorization.substring(7);
        sysUserService.logout(token);
        return Result.build("退出成功", ResultCodeEnum.SUCCESS);
    }

}
