package com.lee.onstage.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Article;
import com.lee.onstage.entity.Output;
import com.lee.onstage.mapper.OutPutMapper;
import com.lee.onstage.model.dto.OutPutDto;
import com.lee.onstage.result.ResponseResult;

public interface OutPutService extends IService<Output> {

    public Output getRandomOutPut();

    ResponseResult addDictum(OutPutDto outPutDto);
}
