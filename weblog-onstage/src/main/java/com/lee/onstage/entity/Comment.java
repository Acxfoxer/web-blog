package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Comment)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Comment implements Serializable {
    private static final long serialVersionUID = -28461941415990258L;
    /**
     * 评论id
     */
    private Long id;
    /**
     * 类型 (1文章 2友链 3说说)
     */
    private Integer commentType;
    /**
     * 类型id (类型为友链则没有值)
     */
    private Integer typeId;
    /**
     * 父评论id
     */
    private Integer parentId;
    /**
     * 回复评论id
     */
    private Integer replyId;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 评论用户id
     */
    private Integer fromUid;
    /**
     * 回复用户id
     */
    private Integer toUid;
    /**
     * 是否通过 (0否 1是)
     */
    private Integer isCheck;
    /**
     * 评论时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

