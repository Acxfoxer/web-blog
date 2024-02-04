package com.lee.onstage.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 谚语警句信息
 * @author Acxfoxer
 * @Date 2023/08/24
 */
@Data
@ApiModel("谚语警句信息")
public class ScrollWordDto {
    /**
     *  名言,警句
     */
    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(value = "谚语|警句|面试小tips|感想|公告")
    private String dictum;
    /**
     * 句子类型
     */
    @NotBlank(message = "类型不能为空")
    @ApiModelProperty(value = "a=谚语|b=警句|c=面试小tips|d=感谢|e=公告")
    private String type;
    /**
     * 来源
     */
    @ApiModelProperty(value = "句子来源")
    private String fromWhere;
    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    private String fromWho;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creator;
    /**
     * 创建用户的id
     */
    @ApiModelProperty(value = "创建者的编号")
    private Integer creatorUid;
    /**
     * 提交信息
     */
    @ApiModelProperty(value = "提交信息")
    private String commitFrom;
}
