package com.lee.onstage.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (UserRole)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class UserRole implements Serializable {
    private static final long serialVersionUID = -87427155855699209L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 角色id
     */
    private String roleId;


}

