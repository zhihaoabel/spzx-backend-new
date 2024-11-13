package com.abel.model.system;


import com.abel.model.system.base.BaseEntity;
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

    private String username;

    private String password;

    private String name;

    private String phone;

    private String avatar;

    private String description;

    private Integer status;
}
