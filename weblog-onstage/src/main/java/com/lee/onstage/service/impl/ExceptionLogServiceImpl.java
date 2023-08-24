package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.ExceptionLogMapper;
import com.lee.onstage.entity.ExceptionLog;
import com.lee.onstage.service.ExceptionLogService;
import org.springframework.stereotype.Service;

/**
 * (ExceptionLog)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("exceptionLogService")
public class ExceptionLogServiceImpl extends ServiceImpl<ExceptionLogMapper, ExceptionLog> implements ExceptionLogService {

}

