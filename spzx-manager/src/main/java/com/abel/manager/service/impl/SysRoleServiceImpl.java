package com.abel.manager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abel.manager.mapper.SysRoleMapper;
import com.abel.manager.service.SysRoleService;
import com.abel.model.dto.system.SysRoleDto;
import com.abel.model.vo.system.SysRoleVo;
import com.abel.manager.page.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleMapper sysRoleMapper;

    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public PageVo<SysRoleVo> findByPage(SysRoleDto params) {
        PageHelper.startPage(params.getCurrent(), params.getPageSize());
        List<SysRoleVo> roles = sysRoleMapper.findByPage(params);
        return new PageVo<>(new PageInfo<>(roles));
    }
}
