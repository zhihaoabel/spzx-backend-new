package com.abel.manager.service.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.abel.common.util.AssertUtil;
import com.abel.manager.mapper.SysUserMapper;
import com.abel.manager.service.SysUserService;
import com.abel.model.dto.system.CaptchaDto;
import com.abel.model.dto.system.LoginDto;
import com.abel.model.entity.system.SysUser;
import com.abel.model.vo.system.LoginVo;
import com.abel.model.vo.system.UserInfoVo;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private CaptchaService captchaService;

    @Override
    public LoginVo login(LoginDto loginDto) {
        // 1. 验证验证码
        boolean validateCaptcha = captchaService.validateCaptcha(new CaptchaDto(loginDto.getKey(), loginDto.getCaptcha()));
        if (!validateCaptcha) {
            throw new RuntimeException("验证码错误");
        }

        // 2. 根据用户名查询用户信息
        SysUser sysUser = sysUserMapper.selectByUsername(loginDto.getUsername());
        if (sysUser == null) {
            throw new RuntimeException("用户名或者密码错误");
        }

        // 3. 判断密码是否正确
        String password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
        if (!sysUser.getPassword().equals(password)) {
            throw new RuntimeException("用户名或者密码错误");
        }

        // 4. 生成token
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("login:token:" + token, JSON.toJSONString(sysUser, JSONWriter.Feature.BrowserSecure), 30, TimeUnit.MINUTES);

        // 5. 返回
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        loginVo.setRefreshToken("");

        return loginVo;
    }

    @Override
    public UserInfoVo getUserInfo(String token) {
        String sysUserJson = redisTemplate.opsForValue().get("login:token:" + token);
        AssertUtil.notEmpty(sysUserJson, () -> "用户未登录");
        // 缓存里存放的是SysUser对象，返回的是UserInfoVo对象
        UserInfoVo userInfoVo = JSON.parseObject(sysUserJson, UserInfoVo.class);
        AssertUtil.notNull(userInfoVo, () -> "用户信息解析失败");
        return userInfoVo;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete("login:token:" + token);
    }

}
