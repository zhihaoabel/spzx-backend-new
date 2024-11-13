package com.abel.common.service.response;

import lombok.Data;

@Data
public class Result<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误数据
     */
    private T data;

    /**
     * 私有构造方法
     */
    private Result() {
    }

    /**
     * @param <T> 泛型
     * @param data 数据
     * @param code 错误码
     * @param message 错误信息
     * @return 成功结果
     */
    public static <T> Result<T> success(T data, Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * @param <T> 泛型
     * @param data 数据
     * @return 成功结果
     */
    public static <T> Result<T> success(T data) {
        return success(data, 20000, "success");
    }

    /**
     * @param <T> 泛型
     * @param message 错误信息
     * @return 成功结果
     */
    public static <T> Result<T> success(String message) {
        return success(null, 20000, message);
    }

    /**
     * @param <T> 泛型
     * @param data 数据
     * @param message 错误信息
     * @return 成功结果
     */
    public static <T> Result<T> success(T data, String message) {
        return success(data, 20000, message);
    }

    /**
     * @param <T> 泛型
     * @param message 错误信息
     * @param data 数据
     * @return 成功结果
     */
    public static <T> Result<T> success(String message, T data) {
        return success(data, 20000, message);
    }

    /**
     * @param <T> 泛型
     * @param code 错误码
     * @param message 错误信息
     * @return 错误结果
     */
    public static <T> Result<T> fail(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    /**
     * @param <T> 泛型
     * @param code 错误码
     * @param message 错误信息
     * @param data 错误数据
     * @return 错误结果
     */
    public static <T> Result<T> fail(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * @param <T> 泛型
     * @param message 错误信息
     * @return 错误结果
     */
    public static <T> Result<T> fail(String message) {
        return fail(50000, message, null);
    }

    /**
     * @param <T> 泛型
     * @param data 响应数据
     * @param resultCodeEnum 响应码枚举
     * @return 响应结果
     */
    public static <T> Result<T> buildWithResultCodeEnum(T data, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        result.setData(data);
        return result;
    }
}
