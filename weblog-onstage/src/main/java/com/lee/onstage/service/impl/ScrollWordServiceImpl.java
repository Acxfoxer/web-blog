package com.lee.onstage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.ResultCode;
import com.lee.onstage.entity.ScrollWorld;
import com.lee.onstage.mapper.ScrollWordMapper;
import com.lee.onstage.model.dto.ScrollWordDto;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.ScrollWordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("outPutService")
public class ScrollWordServiceImpl extends ServiceImpl<ScrollWordMapper, ScrollWorld> implements ScrollWordService {
    @Resource
    private ScrollWordMapper scrollWordMapper;
    @Override
    public ResponseResult<?> getRandomOutPut() {
        ScrollWorld randomOutPut = scrollWordMapper.getRandomOutPut();
        System.out.println(randomOutPut);
        return ResponseResult.success(randomOutPut);
    }

    @Override
    public ResponseResult<?> addDictum(ScrollWordDto scrollWordDto) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        int length= scrollWordDto.getDictum().length();
        ScrollWorld output = new ScrollWorld();
        BeanUtil.copyProperties(scrollWordDto,output);
        output.setUuid(uuid);
        output.setLength(length);
        output.setReviewer(0);
        scrollWordMapper.insert(output);
        return  ResponseResult.success(ResultCode.SUCCESS.getCode(),"插入成功");
    }
}
