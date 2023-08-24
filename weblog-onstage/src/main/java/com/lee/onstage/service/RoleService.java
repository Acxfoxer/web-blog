package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Role;

/**
 * (Role)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:50
 */
public interface RoleService extends IService<Role> {
    /**
     * 获取role信息
     * @param roleId
     * @return
     */
    Role getByRoleId(String roleId);
}

