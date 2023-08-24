package com.lee.onstage.service;

import com.lee.onstage.entity.User;
import com.lee.onstage.result.ResponseResult;

/**
 * @author lei
 * 登录接口
 */
public interface LoginService {
    /**
     * 登录
     * @param user
     * @return
     */
    ResponseResult login(User user);

    /**
     * 登出
     * @return
     */
    ResponseResult logout();
}
