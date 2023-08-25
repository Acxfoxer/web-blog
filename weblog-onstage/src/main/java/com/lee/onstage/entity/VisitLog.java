package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (VisitLog)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class VisitLog implements Serializable {
    private static final long serialVersionUID = 942697781835197730L;
    /**
     * id
     */
    private Long id;
    /**
     * 访问页面
     */
    private String page;
    /**
     * 访问ip
     */
    private String ipAddress;
    /**
     * 访问地址
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
     * 访问时间
     */
    private Date createTime;


}

