package com.abel.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.abel.model.dto.system.role.RoleCreateDto;
import com.abel.model.dto.system.role.RoleQueryDto;
import com.abel.model.dto.system.role.RoleUpdateDto;
import com.abel.model.entity.system.SysRole;
import com.abel.model.vo.system.SysRoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVo> findByPage(Page<SysRoleVo> page, @Param("params") RoleQueryDto params);

    int countByRoleName(String name);

    void insertRole(RoleCreateDto params);

    int countById(String id);

    void updateRole(RoleUpdateDto params);

    void deleteRole(String id);
}
