package com.lee.onstage.service.impl;

import com.lee.onstage.entity.User;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private MyRedisCache redisCache;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public ResponseResult login(User user) {
        //generate authenticationToken
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        return null;
    }


    @Override
    public ResponseResult logout() {
        return null;
    }
}
