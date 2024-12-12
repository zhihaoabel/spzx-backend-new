package com.abel.model.dto.system.user;

import java.io.Serial;

import com.abel.model.dto.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryDto extends BaseDTO {

    @Serial
    private static final long serialVersionUID = 70631960L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

}
