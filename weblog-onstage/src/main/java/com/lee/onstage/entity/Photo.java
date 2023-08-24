package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Photo)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Photo implements Serializable {
    private static final long serialVersionUID = -74262007239075609L;
    /**
     * 照片id
     */
    private Integer id;
    /**
     * 相册id
     */
    private Integer albumId;
    /**
     * 照片名
     */
    private String photoName;
    /**
     * 照片描述
     */
    private String photoDesc;
    /**
     * 照片链接
     */
    private String photoUrl;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

