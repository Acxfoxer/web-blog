package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.ScrollWorld;
import com.lee.onstage.model.dto.ScrollWordDto;
import com.lee.onstage.result.ResponseResult;

public interface ScrollWordService extends IService<ScrollWorld> {

    public ResponseResult getRandomOutPut();

    ResponseResult addDictum(ScrollWordDto scrollWordDto);
}
