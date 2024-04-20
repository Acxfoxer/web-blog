package com.lee.onstage.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 用户注册Dto对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("注册信息")
public class UserRegisterDto {

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String  userName;
    @NotNull(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String code;
}
