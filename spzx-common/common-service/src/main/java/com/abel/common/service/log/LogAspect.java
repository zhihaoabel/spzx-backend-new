package com.abel.commonservice.aspect.log;

import com.abel.commonservice.utils.IpUtils;

import com.abel.commonservice.utils.JsonUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Around("@annotation(logAnnotation)")
    public Object aroundLogWithAnnotation(ProceedingJoinPoint point, Logs logAnnotation) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName = point.getSignature().getName();
        String ip = IpUtils.getIpAddress();

        try {
            // 前置日志
            log.info("IP: {}", ip);
            log.info("{} - 开始执行, 操作: {}", methodName, logAnnotation.value());

            if (logAnnotation.printParams()) {
                // 安全处理参数
                log.info("{} - 方法参数: {}", methodName, JsonUtils.toSafeJson(point.getArgs()));
            }

            Object result = point.proceed();
            log.info("{} - 返回结果: {}", methodName, JsonUtils.toJson(result));

            long duration = System.currentTimeMillis() - startTime;
            log.info("{} - 执行完成, 耗时: {}ms", methodName, duration);

            return result;

        } catch (Exception e) {
            log.error("{} - 执行异常, 异常信息: {}", methodName, e.getMessage());
            throw e;
        } finally {
            MDC.clear();
        }
    }
} 