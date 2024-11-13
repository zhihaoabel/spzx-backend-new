package com.abel.commonservice.aspect.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExceptionLogAspect {

    @Around("@annotation(org.springframework.web.bind.annotation.ExceptionHandler)")
    public Object logException(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Exception e) {
            log.error("""
                异常详情:
                异常类型: {}
                异常消息: {}
                异常位置: {}
                完整堆栈:\s""",
                e.getClass().getName(),
                e.getMessage(),
                e.getStackTrace()[0],
                e);
        }
        return joinPoint.proceed();
    }
}
