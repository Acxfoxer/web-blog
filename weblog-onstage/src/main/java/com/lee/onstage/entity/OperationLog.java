package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (OperationLog)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class OperationLog implements Serializable {
    private static final long serialVersionUID = -67509104721654973L;
    /**
     * 操作id
     */
    private Long id;
    /**
     * 操作模块
     */
    private String module;
    /**
     * 操作类型
     */
    private String type;
    /**
     * 操作uri
     */
    private String uri;
    /**
     * 方法名称
     */
    private String name;
    /**
     * 操作描述
     */
    private String description;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 请求方式
     */
    private String method;
    /**
     * 返回数据
     */
    private String data;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 操作ip
     */
    private String ipAddress;
    /**
     * 操作地址
     */
    private String ipSource;
    /**
     * 操作耗时 (毫秒)
     */
    private Integer times;
    /**
     * 操作时间
     */
    private Date createTime;


}

