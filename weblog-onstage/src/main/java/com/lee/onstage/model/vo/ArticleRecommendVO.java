package com.lee.onstage.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Date;

/**
 * 推荐文章
 *
 * @author ican
 **/
@Data
@ApiModel(description = "推荐文章")
public class ArticleRecommendVO {

    /**
     * 文章id
     */
    @ApiModelProperty(value = "文章id")
    private Long id;

    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

    /**
     * 文章缩略图
     */
    @ApiModelProperty(value = "文章缩略图")
    private String articleCover;

    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private Date createTime;
}