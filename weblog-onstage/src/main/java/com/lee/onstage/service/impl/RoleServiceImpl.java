package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.RoleMapper;
import com.lee.onstage.entity.Role;
import com.lee.onstage.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Role)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:50
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 获取role信息
     * @param roleId
     * @return
     */
    @Override
    public Role getByRoleId(String roleId) {
        return roleMapper.queryById(roleId);
    }
}

