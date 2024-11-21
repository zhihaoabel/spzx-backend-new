package com.abel.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.abel.model.dto.system.SysRoleDto;
import com.abel.model.vo.system.SysRoleVo;

@Mapper
public interface SysRoleMapper {

    List<SysRoleVo> findByPage(SysRoleDto sysRoleDto);
}
