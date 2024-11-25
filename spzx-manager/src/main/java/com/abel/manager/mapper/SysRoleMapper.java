package com.abel.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.abel.model.dto.system.role.RoleCreateDto;
import com.abel.model.dto.system.role.RoleQueryDto;
import com.abel.model.dto.system.role.RoleUpdateDto;
import com.abel.model.vo.system.SysRoleVo;

@Mapper
public interface SysRoleMapper {

    List<SysRoleVo> findByPage(RoleQueryDto sysQueryDto);

    int countByRoleName(String name);

    void insertRole(RoleCreateDto params);

    int countById(String id);

    void updateRole(RoleUpdateDto params);

    void deleteRole(String id);
}
