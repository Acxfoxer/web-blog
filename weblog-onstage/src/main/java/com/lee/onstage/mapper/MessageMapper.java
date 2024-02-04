package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Message)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:50
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}

