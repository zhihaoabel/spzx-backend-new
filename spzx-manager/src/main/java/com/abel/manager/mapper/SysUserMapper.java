package com.abel.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.abel.model.entity.system.SysUser;


@Mapper
public interface SysUserMapper {

    SysUser selectByUsername(String username);

}
