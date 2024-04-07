package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Tag;
import com.lee.onstage.model.vo.TagBackVO;
import com.lee.onstage.model.vo.TagOptionVO;
import com.lee.onstage.model.vo.TagVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 查询所有的标签集合
     * @return
     */
    List<TagOptionVO> selectTagList();

    /**
     * 查询后台标签列表
     * @param limit 当前页码
     * @param size  页数
     * @param keyword 关键字
     * @return
     */
    List<TagBackVO> selectTagBackVo(@Param("limit") int limit, @Param("size") Integer size, @Param("keyword") String keyword);

    /**
     * 查询文章标签列表
     * @return
     */
    List<TagVO> selectTagVOList();
}

