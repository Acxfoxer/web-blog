package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Article)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Article implements Serializable {
    private static final long serialVersionUID = 266191381427547472L;
    /**
     * 文章id
     */
    private Long id;
    /**
     * 作者id
     */
    private Integer userId;
    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 评论id
     */
    private Integer commentId;
    /**
     * 缩略图
     */
    private String articleCover;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 类型 (1原创 2转载 3翻译)
     */
    private Integer articleType;
    /**
     * 是否置顶 (0否 1是）
     */
    private Integer isTop;
    /**
     * 是否删除 (0否 1是)
     */
    private Integer isDelete;
    /**
     * 是否推荐 (0否 1是)
     */
    private Integer isRecommend;
    /**
     * 状态 (1公开 2私密 3评论可见)
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

    private Integer viewCount;

}

