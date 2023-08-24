package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.TaskLogDao;
import com.lee.onstage.entity.TaskLog;
import com.lee.onstage.service.TaskLogService;
import org.springframework.stereotype.Service;

/**
 * (TaskLog)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:54
 */
@Service("taskLogService")
public class TaskLogServiceImpl extends ServiceImpl<TaskLogDao, TaskLog> implements TaskLogService {

}

