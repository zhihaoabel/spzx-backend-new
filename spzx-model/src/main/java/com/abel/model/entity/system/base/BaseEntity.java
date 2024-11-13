package com.abel.model.entity.system.base;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 953779832L;

    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;
}
