package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.UserRole;

import java.util.List;

/**
 * (UserRole)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:55
 */
public interface UserRoleService extends IService<UserRole> {
    /**
     * 获取用户权限关联信息
     * @param id
     * @return
     */
    List<UserRole> getUserRoleByUserId(Long id);
}

