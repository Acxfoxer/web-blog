package com.lee.onstage.mapper;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.VisitLog;
import com.lee.onstage.model.vo.UserViewVO;

import java.util.List;

/**
 * (VisitLog)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:55
 */
public interface VisitLogMapper extends BaseMapper<VisitLog> {

    List<UserViewVO> selectUserViewRecode(DateTime startTime, DateTime endTime);
}

