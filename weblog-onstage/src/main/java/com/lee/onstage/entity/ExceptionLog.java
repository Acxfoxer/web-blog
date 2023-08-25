package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (ExceptionLog)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class ExceptionLog implements Serializable {
    private static final long serialVersionUID = -58149179652321329L;
    /**
     * 异常id
     */
    private Long id;
    /**
     * 异常模块
     */
    private String module;
    /**
     * 异常uri
     */
    private String uri;
    /**
     * 异常名称
     */
    private String name;
    /**
     * 操作描述
     */
    private String description;
    /**
     * 异常方法
     */
    private String errorMethod;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 请求方式
     */
    private String requestMethod;
    /**
     * 操作ip
     */
    private String ipAddress;
    /**
     * 操作地址
     */
    private String ipSource;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 浏览器
     */
    private String browser;
    /**
     * 操作时间
     */
    private Date createTime;


}

