package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.VisitLogMapper;
import com.lee.onstage.entity.VisitLog;
import com.lee.onstage.service.VisitLogService;
import org.springframework.stereotype.Service;

/**
 * (VisitLog)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:55
 */
@Service("visitLogService")
public class VisitLogServiceImpl extends ServiceImpl<VisitLogMapper, VisitLog> implements VisitLogService {

}

