package com.lee.onstage.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 分类后台VO
 *
 * @author ican
 * @date 2022/12/03 21:43
 **/
@Data
@ApiModel(description = "分类后台VO")
public class CategoryBackVO {

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id")
    private Long id;

    /**
     * 分类名
     */
    @ApiModelProperty(value = "分类名")
    private String categoryName;

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