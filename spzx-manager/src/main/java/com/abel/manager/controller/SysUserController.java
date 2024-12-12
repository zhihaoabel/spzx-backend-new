package com.abel.manager.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abel.common.service.log.Logs;
import com.abel.manager.page.PageVo;
import com.abel.manager.service.SysUserService;
import com.abel.model.common.Result;
import com.abel.model.dto.system.user.UserQueryDto;
import com.abel.model.vo.system.UserVo;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/admin/system/users")
public class SysUserController {

    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 分页查询用户列表
     * @param queryDto 查询参数
     * @return 用户列表
     */
    @Logs(value = "分页查询用户列表", printParams = true)
    @GetMapping
    public Result<PageVo<UserVo>> getUsers(@Validated @ModelAttribute UserQueryDto queryDto) {
        return Result.success(sysUserService.findByPage(queryDto));
    }
}
