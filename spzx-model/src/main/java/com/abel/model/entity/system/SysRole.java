package com.abel.model.entity.system;

import java.io.Serial;

import com.abel.model.entity.system.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 999989937L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 描述
     */
    private String description;
}
