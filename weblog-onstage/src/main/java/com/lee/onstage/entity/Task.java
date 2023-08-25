package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Task)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Task implements Serializable {
    private static final long serialVersionUID = -71954575974802536L;
    /**
     * 任务id
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
     * 调用目标
     */
    private String invokeTarget;
    /**
     * cron执行表达式
     */
    private String cronExpression;
    /**
     * 计划执行错误策略 (1立即执行 2执行一次 3放弃执行)
     */
    private Integer misfirePolicy;
    /**
     * 是否并发执行 (0否 1是)
     */
    private Integer concurrent;
    /**
     * 任务状态 (0运行 1暂停)
     */
    private Integer status;
    /**
     * 任务备注信息
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

