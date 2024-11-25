package com.abel.manager.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abel.common.service.log.Logs;
import com.abel.manager.service.SysRoleService;
import com.abel.model.common.Result;
import com.abel.model.dto.system.role.RoleCreateDto;
import com.abel.model.dto.system.role.RoleQueryDto;
import com.abel.model.dto.system.role.RoleUpdateDto;
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
    public Result<PageVo<SysRoleVo>> getRoles(@Validated @ModelAttribute RoleQueryDto params) {
        return Result.success(sysRoleService.findByPage(params));
    }

    @Logs(value = "新增角色", printParams = true)
    @PostMapping
    public Result<Void> createRole(@Validated @RequestBody RoleCreateDto params) {
        sysRoleService.createRole(params);
        return Result.success();
    }

    @Logs(value = "修改角色", printParams = true)
    @PutMapping("/{id}")
    public Result<Void> updateRole(@PathVariable String id,
            @Validated @RequestBody RoleUpdateDto params) {
        params.setId(id);
        sysRoleService.updateRole(params);
        return Result.success();
    }

    @Logs(value = "删除角色", printParams = true)
    @DeleteMapping("/{id}")
    public Result<Void> deleteRole(@PathVariable String id) {
        sysRoleService.deleteRole(id);
        return Result.success();
    }
}
