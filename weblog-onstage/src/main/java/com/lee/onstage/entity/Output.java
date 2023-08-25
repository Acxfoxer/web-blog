package com.lee.onstage.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * (Output)实体类
 *
 * @author makejava
 * @since 2023-06-08 13:53:06
 */
@Data
@TableName("t_output")
public class Output implements Serializable {
    private static final long serialVersionUID = -56631749792973001L;
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     *  信息uuid
     */
    private String uuid;
    /**
     *  名言,警句
     */
    private String dictum;
    /**
     * 句子类型,a=谚语|b=警句|c=面试小tips|d=感谢|e=公告
     */
    private String type;
    /**
     * 来源
     */
    private String fromWhere;
    /**
     * 作者
     */
    private String fromWho;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建用户的id
     */
    private Integer creatorUid;
    /**
     * 查看数量
     */
    private Integer reviewer;
    /**
     * 提交信息
     */
    private String commitFrom;
    /**
     * 创建日期
     */

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    /**
     * 长度
     */
    private Integer length;


}

