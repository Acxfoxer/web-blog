package com.lee.onstage.annotation;

import java.lang.annotation.*;

/**
 * 操作日志
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OptLogger {
    String value() default "";
}
