package com.abel.manager;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.abel.common.service.exception.ExceptionLogAspect;
import com.abel.common.service.exception.GlobalExceptionHandler;
import com.abel.common.service.log.LogAspect;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
@Import({GlobalExceptionHandler.class, LogAspect.class, ExceptionLogAspect.class})
@MapperScan("com.abel.manager.mapper")
public class SpzxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpzxManagerApplication.class, args);
    }
}
