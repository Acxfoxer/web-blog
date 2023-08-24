package com.lee.onstage.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 登录信息
 * @author  lei
 * @createTime 2023/5/11
 */
@Data
@ApiModel(description = "登录信息")
public class LoginDto {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Size(min=8,message = "密码不能小于8位")
    @ApiModelProperty(value = "用户密码")
    private String password;
}
