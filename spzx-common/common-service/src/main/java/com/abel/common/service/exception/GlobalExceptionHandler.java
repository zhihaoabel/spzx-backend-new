package com.abel.common.service.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.abel.common.service.utils.ErrorMessageUtils;
import com.abel.model.common.Result;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Value("${spring.profiles.active:prod}")
    private String activeProfile;

    /**
     * 顶层异常
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        // 获取友好的错误消息
        String errorMessage = ErrorMessageUtils.getFriendlyMessage(e);

        // 在开发环境返回详细错误信息
        if ("dev".equals(activeProfile)) {
            errorMessage = ErrorMessageUtils.getDetailedMessage(e);
        }

        log.error("系统异常: {}", errorMessage);
        return Result.fail(errorMessage);
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<String> handleRuntimeException(RuntimeException e) {
        // 获取友好的错误消息
        String errorMessage = ErrorMessageUtils.getFriendlyMessage(e);

        return Result.fail(errorMessage);
    }

    /**
     * NoResourceFoundException
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public Result<String> handleNoResourceFoundException(NoResourceFoundException e) {
        String errorMessage = ErrorMessageUtils.getFriendlyMessage(e);

        return Result.fail(errorMessage);
    }

    /**
     * MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 获取具体的验证错误信息
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse(e.getMessage());

        return Result.fail(errorMessage);
    }
}
