package com.lee.onstage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 访问日志切面类
 */
@Aspect
@Component
public class VisitLogAspect {
    /**
     * 连接点
     */
    @Pointcut("@annotation(com.lee.onstage.annotation.VisitLogger)")
    public void VisitLogAspect(){
    }

    /**
     * 切点的方法执行正常返回的日志,主要记录用户日志,如果连接点抛出异常，则不会执行
     * @param joinPoint 切面方法的信息
     * @param result    返回结果
     */
    @AfterReturning(value = "VisitLogAspect()",returning = "result")
    public void doAfterReturning(JoinPoint joinPoint,Object result){

    }
}
