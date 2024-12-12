package com.abel.model.vo.system;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 573332477L;

    /**
     * id
     */
    private Long id;

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

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态（1：正常 0：停用）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createdAt;

}
