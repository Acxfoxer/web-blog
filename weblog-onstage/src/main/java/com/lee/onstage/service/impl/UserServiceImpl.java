package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.entity.User;
import com.lee.onstage.mapper.UserMapper;
import com.lee.onstage.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:54
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public User getUserByName(String username) {
        return userMapper.getByUsernameUser(username);
    }
}

