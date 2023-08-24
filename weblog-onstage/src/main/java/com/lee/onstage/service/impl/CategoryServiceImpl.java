package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.CategoryMapper;
import com.lee.onstage.entity.Category;
import com.lee.onstage.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * (Category)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

