package com.abel.manager.service;

import com.abel.model.dto.system.role.RoleCreateDto;
import com.abel.model.dto.system.role.RoleQueryDto;
import com.abel.model.vo.system.SysRoleVo;
import com.abel.manager.page.PageVo;
import com.abel.model.dto.system.role.RoleUpdateDto;

public interface SysRoleService {

    PageVo<SysRoleVo> findByPage(RoleQueryDto params);

    void createRole(RoleCreateDto params);

    void updateRole(RoleUpdateDto params);

    public void deleteRole(String id);
}
