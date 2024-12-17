package com.abel.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.abel.model.dto.system.user.UserQueryDto;
import com.abel.model.entity.system.SysUser;
import com.abel.model.vo.system.UserVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByUsername(String username);

    List<UserVo> findByPage(Page<UserVo> page, @Param("params") UserQueryDto queryDto);

}
