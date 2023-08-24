package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Role)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Role implements Serializable {
    private static final long serialVersionUID = 601674877868833638L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 是否禁用 (0否 1是)
     */
    private Integer isDisable;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

