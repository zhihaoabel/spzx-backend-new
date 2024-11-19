package com.abel.manager;


import com.abel.common.service.exception.ExceptionLogAspect;
import com.abel.common.service.exception.GlobalExceptionHandler;
import com.abel.common.service.log.LogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
@Import({GlobalExceptionHandler.class, LogAspect.class, ExceptionLogAspect.class})
public class SpzxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpzxManagerApplication.class, args);
    }
}
