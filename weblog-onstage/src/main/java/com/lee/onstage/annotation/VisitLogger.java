package com.lee.onstage.annotation;

import java.lang.annotation.*;

/**
 * 访问日志,登录用户,未登录用户
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface VisitLogger {
    String value() default "";
}
