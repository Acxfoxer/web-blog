package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Friend)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Friend implements Serializable {
    private static final long serialVersionUID = -87258873136458023L;
    /**
     * 友链id
     */
    private Integer id;
    /**
     * 友链名称
     */
    private String name;
    /**
     * 友链颜色
     */
    private String color;
    /**
     * 友链头像
     */
    private String avatar;
    /**
     * 友链地址
     */
    private String url;
    /**
     * 友链介绍
     */
    private String introduction;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

