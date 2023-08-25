package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Tag;
import com.lee.onstage.model.vo.TagOptionVO;

import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 查询所有的标签集合
     * @return
     */
    List<TagOptionVO> selectTagList();
}

