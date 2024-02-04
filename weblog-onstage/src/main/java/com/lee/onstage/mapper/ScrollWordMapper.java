package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.ScrollWorld;
import org.mapstruct.Mapper;

@Mapper
public interface ScrollWordMapper extends BaseMapper<ScrollWorld> {

    public ScrollWorld getRandomOutPut();

    void addOutPut(ScrollWorld output);
}
