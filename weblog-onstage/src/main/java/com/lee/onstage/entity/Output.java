package com.lee.onstage.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Output)实体类
 *
 * @author makejava
 * @since 2023-06-08 13:53:06
 */
@Data
public class Output implements Serializable {
    private static final long serialVersionUID = -56631749792975001L;

    private Integer id;

    private String uuid;

    private String dictum;

    private String type;

    private String from;

    private String fromWho;

    private String creator;

    private Integer creatorUid;

    private String reviewer;

    private String commitFrom;

    private Date createdAt;

    private Integer length;


}

