package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.UserRole;

import java.util.List;

/**
 * (UserRole)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:55
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<UserRole> getByUserId(Long userId);
}

