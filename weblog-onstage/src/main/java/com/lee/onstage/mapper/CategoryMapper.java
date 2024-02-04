package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Category;
import com.lee.onstage.model.vo.CategoryBackVO;
import com.lee.onstage.model.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Category)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryVO> selectCategoryVOList();
}

