package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Category;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.CategoryBackVO;
import com.lee.onstage.model.vo.CategoryVO;
import com.lee.onstage.model.vo.PageResult;

import java.util.List;

/**
 * (Category)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
public interface CategoryService extends IService<Category> {

    /**
     * 获取文章分类
     * @param pageParamDto
     * @return
     */
    PageResult<CategoryBackVO> listCategoryBackVo(PageParamDto pageParamDto);

    List<CategoryVO> listCategoryVo();
}

