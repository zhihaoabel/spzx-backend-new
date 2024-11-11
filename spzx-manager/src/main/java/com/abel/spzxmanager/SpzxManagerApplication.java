package com.abel.spzxmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.abel.commonservice.aspect.log.LogAspect;
import com.abel.commonservice.exception.GlobalExceptionHandler;

@SpringBootApplication
@EnableAspectJAutoProxy
@Import({GlobalExceptionHandler.class, LogAspect.class})
public class SpzxManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpzxManagerApplication.class, args);
    }

}
