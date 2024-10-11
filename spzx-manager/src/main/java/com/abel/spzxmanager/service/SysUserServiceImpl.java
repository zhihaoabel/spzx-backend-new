package com.abel.spzxmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abel.spzxmanager.mapper.SysUserMapper;
import com.abel.spzxmodel.dto.system.LoginDto;
import com.abel.spzxmodel.vo.system.LoginVo;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public LoginVo login(LoginDto loginDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
