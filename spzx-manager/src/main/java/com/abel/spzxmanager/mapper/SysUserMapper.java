package com.abel.spzxmanager.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.abel.spzxmodel.entity.system.SysUser;

@Mapper
public interface SysUserMapper {

    SysUser selectByUsername(String username);

}
