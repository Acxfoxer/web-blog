package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Message)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Message implements Serializable {
    private static final long serialVersionUID = 593908180059635446L;
    /**
     * 留言id
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 留言内容
     */
    private String messageContent;
    /**
     * 用户ip
     */
    private String ipAddress;
    /**
     * 用户地址
     */
    private String ipSource;
    /**
     * 是否通过 (0否 1是)
     */
    private Integer isCheck;
    /**
     * 留言时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

