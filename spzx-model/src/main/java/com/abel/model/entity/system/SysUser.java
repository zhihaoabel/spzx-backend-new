package com.abel.model.entity.system;


import com.abel.model.entity.system.base.BaseEntity;
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
public class SysUser extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 905552787L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private Integer status;
}
