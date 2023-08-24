package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.TaskMapper;
import com.lee.onstage.entity.Task;
import com.lee.onstage.service.TaskService;
import org.springframework.stereotype.Service;

/**
 * (Task)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:51
 */
@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}

