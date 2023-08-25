package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Menu;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户id查看用户权限
     */
    public List<Menu> selectByUserId(Long userId);

}

