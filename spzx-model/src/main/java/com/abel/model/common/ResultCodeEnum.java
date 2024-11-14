package com.abel.model.common;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(20000, "成功"),
    FAIL(50000, "失败"),
    RESOURCE_NOT_FOUND(50001, "资源不存在");

    private final Integer code;
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
