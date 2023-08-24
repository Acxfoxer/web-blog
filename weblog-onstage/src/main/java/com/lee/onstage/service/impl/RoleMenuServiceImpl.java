package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.RoleMenuMapper;
import com.lee.onstage.entity.RoleMenu;
import com.lee.onstage.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * (RoleMenu)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}

