package com.abel.manager.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abel.common.service.log.Logs;
import com.abel.manager.service.SysRoleService;
import com.abel.model.common.Result;
import com.abel.model.dto.system.SysRoleDto;
import com.abel.model.vo.system.SysRoleVo;
import com.abel.manager.page.PageVo;

@RestController
@RequestMapping("/admin/system/roles")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Logs(value = "分页查询角色列表", printParams = true)
    @GetMapping
    public Result<PageVo<SysRoleVo>> getRoles(@Validated @ModelAttribute SysRoleDto params) {
        return Result.success(sysRoleService.findByPage(params));
    }
}
