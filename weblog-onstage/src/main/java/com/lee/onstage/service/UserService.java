package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.User;

/**
 * (User)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:54
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getUserByName(String username);
}

