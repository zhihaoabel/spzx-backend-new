package com.abel.spzxmanager.service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.abel.spzxmanager.mapper.SysUserMapper;
import com.abel.spzxmodel.dto.system.LoginDto;
import com.abel.spzxmodel.entity.system.SysUser;
import com.abel.spzxmodel.vo.system.LoginVo;
import com.alibaba.fastjson2.JSON;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public LoginVo login(LoginDto loginDto) {

        // 1. 根据用户名查询用户信息
        SysUser sysUser = sysUserMapper.selectByUsername(loginDto.getUserName());
        if (sysUser == null) {
            throw new RuntimeException("用户名或者密码错误");
        }

        // 2. 判断密码是否正确
        String password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
        if (!sysUser.getPassword().equals(password)) {
            throw new RuntimeException("用户名或者密码错误");
        }

        // 3. 生成token
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("login:token:" + token, JSON.toJSONString(sysUser), 30, TimeUnit.MINUTES);

        // 4. 返回
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        loginVo.setRefreshToken("");

        return loginVo;
    }

}
