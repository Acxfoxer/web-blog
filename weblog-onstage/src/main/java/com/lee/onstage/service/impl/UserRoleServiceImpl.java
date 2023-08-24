package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.UserRoleMapper;
import com.lee.onstage.entity.UserRole;
import com.lee.onstage.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRole)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:55
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 获取用户权限关联信息
     *
     * @param id
     * @return
     */
    @Override
    public List<UserRole> getUserRoleByUserId(Integer id) {
        return userRoleMapper.getByUserId(id);
    }
}

