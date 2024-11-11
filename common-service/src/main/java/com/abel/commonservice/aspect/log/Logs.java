package com.abel.commonservice.aspect.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logs {
    /**
     * 操作描述
     */
    String value() default "";
    
    /**
     * 是否打印返回值
     */
    boolean printResult() default true;
    
    /**
     * 是否打印参数
     */
    boolean printParams() default true;
} 