package com.lee.onstage.service.impl;

import com.lee.onstage.entity.Output;
import com.lee.onstage.mapper.OutPutMapper;
import com.lee.onstage.service.OutPutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class OutPutServiceImpl implements OutPutService {
    @Resource
    private OutPutMapper outPutMapper;
    @Override
    public Output getRandomOutPut() {
        return outPutMapper.getRandomOutPut();
    }
}
