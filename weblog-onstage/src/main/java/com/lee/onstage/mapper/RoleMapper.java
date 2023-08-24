package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Role;

/**
 * (Role)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:50
 */
public interface RoleMapper extends BaseMapper<Role> {

    Role queryById(String roleId);
}

