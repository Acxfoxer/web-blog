package com.lee.onstage.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (RoleMenu)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -11461452842060131L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 菜单id
     */
    private Integer menuId;


}

