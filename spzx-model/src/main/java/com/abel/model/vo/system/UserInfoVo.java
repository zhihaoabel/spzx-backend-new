package com.abel.model.vo.system;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 436083375L;

    private Long id;
    private String userName;
    private String name;
    private String phone;
    private String avatar;
    private String description;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Boolean isDeleted;

}
