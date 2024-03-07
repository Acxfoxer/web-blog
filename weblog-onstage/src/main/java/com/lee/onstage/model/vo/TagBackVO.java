package com.lee.onstage.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 标签后台VO
 *
 * @author ican
 * @date 2022/12/04 22:37
 **/
@Data
@ApiModel(description = "标签后台VO")
public class TagBackVO {

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

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}