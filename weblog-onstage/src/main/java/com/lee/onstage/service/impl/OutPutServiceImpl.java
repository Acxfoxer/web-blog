package com.lee.onstage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.ResultCode;
import com.lee.onstage.entity.Output;
import com.lee.onstage.mapper.OutPutMapper;
import com.lee.onstage.model.dto.OutPutDto;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.OutPutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("outPutService")
public class OutPutServiceImpl extends ServiceImpl<OutPutMapper,Output> implements OutPutService {
    @Resource
    private OutPutMapper outPutMapper;
    @Override
    public Output getRandomOutPut() {
        return outPutMapper.getRandomOutPut();
    }

    @Override
    public ResponseResult<?> addDictum(OutPutDto outPutDto) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        int length=outPutDto.getDictum().length();
        Output output = new Output();
        BeanUtil.copyProperties(outPutDto,output);
        output.setUuid(uuid);
        output.setLength(length);
        output.setReviewer(0);
        outPutMapper.insert(output);
        return  ResponseResult.success(ResultCode.SUCCESS.getValue(),"插入成功");
    }
}
