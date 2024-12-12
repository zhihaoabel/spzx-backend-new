package com.abel.model.dto.base;

import java.io.Serial;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 506417628L;

    /**
     * 页码
     */
    @Min(value = 1, message = "页码不能小于1")
    private Integer current;

    /**
     * 每页条数
     */
    @Min(value = 1, message = "每页条数不能小于1")
    @Max(value = 200, message = "每页条数不能大于200")
    private Integer pageSize;

    /**
     * 创建时间开始
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTimeBegin;

    /**
     * 创建时间结束
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTimeEnd;
}
