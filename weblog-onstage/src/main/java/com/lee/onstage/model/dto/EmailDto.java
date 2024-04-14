package com.lee.onstage.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 邮件信息
 * @author Acxfoxer
 * @date 20240412
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDto {
    /**
     * 发送邮箱列表
     */
    @NotNull
    @ApiModelProperty(value = "邮箱列表")
    private List<String> emailAccounts;
    /**
     * 主题
     */
    @NotNull
    @ApiModelProperty(value = "主题")
    private String subject;
    /**
     * 发送内容
     */

    @NotNull
    @ApiModelProperty(value = "发送内容")
    private String content;
    /**
     * 内容信息
     */

    @NotNull
    @ApiModelProperty(value = "内容详细信息")
    private Map<String, Object> contentMap;

    /**
     * 邮件模板
     */

    @NotNull
    @ApiModelProperty(value = "邮件模板")
    private String template;
}
