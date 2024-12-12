package com.abel.common.service.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

public class ErrorMessageUtils {
    
    // 错误消息映射
    private static final Map<Class<? extends Throwable>, String> ERROR_MESSAGES = Map.of(
        NullPointerException.class, "系统处理时遇到空值",
        IllegalArgumentException.class, "参数不合法",
        IOException.class, "IO操作异常",
        SQLException.class, "数据库操作异常",
        NoResourceFoundException.class, "资源不存在",
        MethodArgumentNotValidException.class, "参数验证失败"

        // 可以添加更多映射
    );

    // 默认错误消息
    private static final String DEFAULT_ERROR_MESSAGE = "系统异常";
    
    /**
     * 获取友好的错误消息
     */
    public static String getFriendlyMessage(Throwable e) {
        if (e == null) {
            return DEFAULT_ERROR_MESSAGE;
        }
        
        // 1. 检查异常自带消息
        String message = e.getMessage();
        if (message != null && !message.trim().isEmpty()) {
            return message;
        }
        
        // 2. 查找预定义消息
        String predefinedMessage = ERROR_MESSAGES.get(e.getClass());
        if (predefinedMessage != null) {
            return predefinedMessage;
        }
        // 3. 检查cause链
        Throwable cause = e.getCause();
        while (cause != null) {
            message = cause.getMessage();
            if (message != null && !message.trim().isEmpty()) {
                return message;
            }
            
            predefinedMessage = ERROR_MESSAGES.get(cause.getClass());
            if (predefinedMessage != null) {
                return predefinedMessage;
            }
            
            cause = cause.getCause();
        }
        
        // 4. 返回默认消息
        return String.format("系统异常 [%s]", e.getClass().getSimpleName());
    }
    
    /**
     * 获取开发环境详细错误信息
     */
    public static String getDetailedMessage(Throwable e) {
        if (e == null) {
            return DEFAULT_ERROR_MESSAGE;
        }
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        
        return sw.toString();
    }
}