package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Menu;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
public interface MenuService extends IService<Menu> {
    /**
     * 根据用户id返回菜单列表
     * @param id
     * @return
     */
    List<Menu> getByUserId(Integer id);
}

