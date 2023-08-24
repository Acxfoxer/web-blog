package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.OperationLogMapper;
import com.lee.onstage.entity.OperationLog;
import com.lee.onstage.service.OperationLogService;
import org.springframework.stereotype.Service;

/**
 * (OperationLog)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("operationLogService")
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {

}

