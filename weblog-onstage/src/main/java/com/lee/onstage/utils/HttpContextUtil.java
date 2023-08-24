package com.lee.onstage.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author lei
 * http上下文对象工具
 */
public class HttpContextUtil {
    private HttpContextUtil(){
    }
    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes)Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
    public static HttpServletResponse getHttpServletResponse(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }
}
