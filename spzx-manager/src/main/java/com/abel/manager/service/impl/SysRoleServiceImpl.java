package com.abel.manager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abel.manager.mapper.SysRoleMapper;
import com.abel.manager.page.PageVo;
import com.abel.manager.service.SysRoleService;
import com.abel.model.dto.system.role.RoleCreateDto;
import com.abel.model.dto.system.role.RoleQueryDto;
import com.abel.model.dto.system.role.RoleUpdateDto;
import com.abel.model.vo.system.SysRoleVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleMapper sysRoleMapper;

    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public PageVo<SysRoleVo> findByPage(RoleQueryDto params) {
        Page<SysRoleVo> page = new Page<>(params.getCurrent(), params.getPageSize());
        List<SysRoleVo> roles = sysRoleMapper.findByPage(page, params);
        return new PageVo<>(page, roles);
    }

    @Override
    public void createRole(RoleCreateDto params) {
        // 1. 检查角色名称是否存在
        if (sysRoleMapper.countByRoleName(params.getName()) > 0) {
            throw new RuntimeException("角色名称已存在");
        }
        // 2. 插入角色
        sysRoleMapper.insertRole(params);
    }

    @Override
    public void updateRole(RoleUpdateDto params) {
        // 1. 检查角色是否存在
        if (sysRoleMapper.countById(params.getId()) == 0) {
            throw new RuntimeException("角色不存在");
        }
        // 2. 更新角色
        sysRoleMapper.updateRole(params);
    }

    @Override
    public void deleteRole(String id) {
        // 1. 检查角色是否存在
        if (sysRoleMapper.countById(id) == 0) {
            throw new RuntimeException("角色不存在");
        }
        // 2. 删除角色
        sysRoleMapper.deleteRole(id);
    }
}
