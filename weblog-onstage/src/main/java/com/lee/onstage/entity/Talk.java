package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Talk)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Talk implements Serializable {
    private static final long serialVersionUID = -36058967759146579L;
    /**
     * 说说id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 说说内容
     */
    private String talkContent;
    /**
     * 说说图片
     */
    private String images;
    /**
     * 是否置顶 (0否 1是)
     */
    private Integer isTop;
    /**
     * 状态 (1公开  2私密)
     */
    private Integer status;
    /**
     * 发表时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

