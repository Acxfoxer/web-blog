package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (User)实体类
 * @author lee
 * @since 2023-05-07 15:45:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class User implements Serializable {
    private static final long serialVersionUID = -93767640626208394L;
    /**
     * 用户id
     */
    private Long id;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 个人网站
     */
    private String webSite;
    /**
     * 个人简介
     */
    private String intro;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 登录ip
     */
    private String ipAddress;
    /**
     * 登录地址
     */
    private String ipSource;
    /**
     * 登录方式 (1邮箱 2QQ 3Gitee 4Github 5微信)
     */
    private Integer loginType;
    /**
     * 是否禁用 (0否 1是)
     */
    private Integer isDisable;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;


}

