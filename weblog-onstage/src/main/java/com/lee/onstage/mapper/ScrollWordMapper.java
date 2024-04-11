package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.ScrollWorld;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScrollWordMapper extends BaseMapper<ScrollWorld> {

    ScrollWorld getRandomOutPut();

    void addOutPut(ScrollWorld output);
}
