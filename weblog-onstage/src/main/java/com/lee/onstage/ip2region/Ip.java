package com.lee.onstage.ip2region;

import org.aspectj.lang.annotation.Around;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ip {
}
