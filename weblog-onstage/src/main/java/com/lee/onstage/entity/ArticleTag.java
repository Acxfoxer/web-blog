package com.lee.onstage.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (ArticleTag)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class ArticleTag implements Serializable {
    private static final long serialVersionUID = -37552426906149246L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 标签id
     */
    private Integer tagId;


}

