package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (BlogFile)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class BlogFile implements Serializable {
    private static final long serialVersionUID = 548008691393718236L;
    /**
     * 文件id
     */
    private Long id;
    /**
     * 文件url
     */
    private String fileUrl;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件大小
     */
    private Integer fileSize;
    /**
     * 文件类型
     */
    private String extendName;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 是否为目录 (0否 1是)
     */
    private Integer isDir;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

