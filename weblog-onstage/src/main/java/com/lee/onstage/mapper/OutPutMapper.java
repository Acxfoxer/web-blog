package com.lee.onstage.mapper;

import com.lee.onstage.entity.Output;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OutPutMapper {

    public Output getRandomOutPut();
}
