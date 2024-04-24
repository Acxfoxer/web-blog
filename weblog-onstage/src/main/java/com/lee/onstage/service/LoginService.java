package com.lee.onstage.service;

import com.lee.onstage.entity.User;
import com.lee.onstage.model.dto.UserRegisterDto;
import com.lee.onstage.result.ResponseResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lei
 * 登录接口
 */
public interface LoginService {
    /**
     * 登录
     * @param user 登录用户信息
     * @return ResponseResult
     */
    ResponseResult<?> login(User user);

    /**
     * 登出
     * @return  ResponseResult
     */
    ResponseResult<?> logout();

    /**
     * 发送验证码
     * @param email 邮箱地址
     */
    void sendCode(String email);

    /**
     * 新用户注册
     * @param userRegisterDto 用户注册信息
     */
    void register(UserRegisterDto userRegisterDto, HttpServletRequest httpServletRequest);
}
