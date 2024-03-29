package com.lee.onstage.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 标签VO
 *
 * @author ican
 **/
@Data
@ApiModel(description = "标签VO")
public class TagVO {

    /**
     * 标签id
     */
    @ApiModelProperty(value = "标签id")
    private Long id;

    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名")
    private String tagName;

    /**
     * 文章数量
     */
    @ApiModelProperty(value = "文章数量")
    private Integer articleCount;
}