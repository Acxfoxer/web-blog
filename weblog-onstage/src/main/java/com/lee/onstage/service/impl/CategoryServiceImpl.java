package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.entity.Category;
import com.lee.onstage.mapper.CategoryMapper;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.CategoryBackVO;
import com.lee.onstage.model.vo.CategoryVO;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.service.CategoryService;
import com.lee.onstage.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Category)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;
    @Override
    public PageResult<CategoryBackVO> listCategoryBackVo(PageParamDto pageParamDto) {
        Long count = categoryMapper.selectCount(new LambdaQueryWrapper<Category>()
                .like(StringUtils.isNotBlank(pageParamDto.getKeyword()),
                        Category::getCategoryName, pageParamDto.getKeyword()));
        List<CategoryBackVO> categoryBackVOS = categoryMapper.selectCategoryBackVo(PageUtils.getLimit(pageParamDto),
                PageUtils.getSize(pageParamDto),
                pageParamDto.getKeyword());
        return new PageResult<>(categoryBackVOS,count);

    }

    @Override
    public List<CategoryVO> listCategoryVo() {
        return categoryMapper.selectCategoryVOList();
    }
}

