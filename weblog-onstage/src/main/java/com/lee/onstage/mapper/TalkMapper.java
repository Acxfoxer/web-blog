package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.model.vo.TalkVO;
import org.apache.ibatis.annotations.Mapper;
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
     * @param current
     * @param size
     * @return
     */
    @Select("select t.*,tu.avatar from t_talk t left join t_user tu on tu.id=t.user_id where t.status=1 order by is_top desc,id desc limit #{current},#{size}")
    List<TalkVO> selectTalkList(int current, int size);
}

