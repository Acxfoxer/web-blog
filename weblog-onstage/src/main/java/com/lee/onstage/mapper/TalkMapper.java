package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.model.vo.TalkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Talk)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Mapper
public interface TalkMapper extends BaseMapper<Talk> {
    /**
     * 查询列表
     * @param limit 当前页数
     * @param size  限制条数
     * @return
     */
    List<TalkVO> selectTalkList(@Param("limit") int limit, @Param("size") int size);

    /**
     * 根据id查询说说
     * @param id 说说id
     * @return
     */
    TalkVO selectTalkById(String id);
}

