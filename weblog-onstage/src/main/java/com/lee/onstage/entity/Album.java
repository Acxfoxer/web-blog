package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Album)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class Album implements Serializable {
    private static final long serialVersionUID = 845177298911432055L;
    /**
     * 相册id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 相册名
     */
    private String albumName;
    /**
     * 相册封面
     */
    private String albumCover;
    /**
     * 相册描述
     */
    private String albumDesc;
    /**
     * 状态 (1公开 2私密)
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

