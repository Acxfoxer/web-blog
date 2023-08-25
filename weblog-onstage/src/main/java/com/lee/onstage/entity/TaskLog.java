package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (TaskLog)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class TaskLog implements Serializable {
    private static final long serialVersionUID = 785408344677425739L;
    /**
     * 任务日志id
     */
    private Long id;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务组名
     */
    private String taskGroup;
    /**
     * 调用目标字符串
     */
    private String invokeTarget;
    /**
     * 日志信息
     */
    private String taskMessage;
    /**
     * 执行状态 (0失败 1正常)
     */
    private Integer status;
    /**
     * 错误信息
     */
    private String errorInfo;
    /**
     * 创建时间
     */
    private Date createTime;


}

