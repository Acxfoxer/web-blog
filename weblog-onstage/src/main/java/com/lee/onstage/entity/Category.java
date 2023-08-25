package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Category)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Category implements Serializable {
    private static final long serialVersionUID = 267545687081629668L;
    /**
     * 分类id
     */
    private Long id;
    /**
     * 分类名
     */
    private String categoryName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

