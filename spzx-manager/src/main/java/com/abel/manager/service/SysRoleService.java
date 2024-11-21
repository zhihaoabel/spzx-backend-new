package com.abel.manager.service;

import com.abel.model.dto.system.SysRoleDto;
import com.abel.model.vo.system.SysRoleVo;
import com.abel.manager.page.PageVo;

public interface SysRoleService {

    PageVo<SysRoleVo> findByPage(SysRoleDto params);
}
