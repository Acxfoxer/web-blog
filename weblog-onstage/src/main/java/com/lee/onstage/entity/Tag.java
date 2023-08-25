package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Tag)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Tag implements Serializable {
    private static final long serialVersionUID = -90784239388002587L;
    /**
     * 标签id
     */
    private Long id;
    /**
     * 标签名
     */
    private String tagName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

