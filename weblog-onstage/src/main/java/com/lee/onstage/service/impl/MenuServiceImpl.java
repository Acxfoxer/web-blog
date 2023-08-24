package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.MenuMapper;
import com.lee.onstage.entity.Menu;
import com.lee.onstage.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 根据用户id返回菜单列表
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<Menu> getByUserId(Integer userId) {
        return menuMapper.selectByUserId(userId);
    }
}

