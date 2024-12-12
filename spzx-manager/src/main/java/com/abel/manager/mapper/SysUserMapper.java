package com.abel.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.abel.model.dto.system.user.UserQueryDto;
import com.abel.model.entity.system.SysUser;
import com.abel.model.vo.system.UserVo;


@Mapper
public interface SysUserMapper {

    SysUser selectByUsername(String username);

    public List<UserVo> findByPage(UserQueryDto queryDto);

}
