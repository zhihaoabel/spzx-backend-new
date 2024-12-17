package com.abel.model.entity.system;


import com.abel.model.entity.system.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
/**
 * id
 * username
 * password
 * name
 * phone
 * avatar
 * description
 * status
 * create_time
 * update_time
 * is_deleted
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 905552787L;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 真实姓名
     */
    @TableField("name")
    private String name;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;
}
