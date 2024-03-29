package com.lee.onstage.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 文章归档
 *
 * @author ican
 */
@Data
@ApiModel(description = "文章归档")
public class ArchiveVO {

    /**
     * 文章id
     */
    @ApiModelProperty(value = "文章id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String articleTitle;

    /**
     * 文章缩略图
     */
    @ApiModelProperty(value = "文章缩略图")
    private String articleCover;

    /**
     * 发表时间
     */
    @ApiModelProperty(value = "发表时间")
    private Date createTime;
}
