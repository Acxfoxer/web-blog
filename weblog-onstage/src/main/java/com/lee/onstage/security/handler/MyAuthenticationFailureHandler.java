package com.lee.onstage.security.handler;


import com.alibaba.fastjson2.JSON;
import com.lee.onstage.result.ResponseResult;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**F
 * @author codermy
 * @createTime 2020/8/2
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //修改编码格式
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json");

        if (e instanceof BadCredentialsException){

            httpServletResponse.getWriter().write(JSON.toJSONString(ResponseResult.error("用户名或者密码错误")));
            //登录失败重定向的失败的页面
            httpServletResponse.sendRedirect("/loginFail.html");
        }else {
            httpServletResponse.getWriter().write(JSON.toJSONString(ResponseResult.error(e.getMessage())));
        }

    }
}
