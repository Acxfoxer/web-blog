package com.lee.onstage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 异常日志记录
 */
@Aspect
@Component
public class ExceptionLogAspect {

    /**
     * 选择controller包下所有方法作为连接点
     */
    @Pointcut("execution(* com.lee.onstage.controller.*.*(..))")
    public void ExceptionLogAspect(){

    }
    @AfterThrowing(pointcut ="ExceptionLogAspect()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Exception e){

    }
}
