package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Output;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OutPutMapper extends BaseMapper<Output> {

    public Output getRandomOutPut();

    void addOutPut(Output output);
}
