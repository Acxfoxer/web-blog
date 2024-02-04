package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 * @author lee
 * @since 2023-05-07 15:45:54
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public User getByUsernameUser(String userName);
}

