package com.lee.onstage.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (SiteConfig)实体类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressWarnings("serial")
public class SiteConfig implements Serializable {
    private static final long serialVersionUID = 943880188525465158L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 游客头像
     */
    private String touristAvatar;
    /**
     * 网站名称
     */
    private String siteName;
    /**
     * 网站地址
     */
    private String siteAddress;
    /**
     * 网站简介
     */
    private String siteIntro;
    /**
     * 网站公告
     */
    private String siteNotice;
    /**
     * 建站日期
     */
    private String createSiteTime;
    /**
     * 备案号
     */
    private String recordNumber;
    /**
     * 作者头像
     */
    private String authorAvatar;
    /**
     * 网站作者
     */
    private String siteAuthor;
    /**
     * 文章默认封面
     */
    private String articleCover;
    /**
     * 关于我
     */
    private String aboutMe;
    /**
     * Github
     */
    private String github;
    /**
     * Gitee
     */
    private String gitee;
    /**
     * 哔哩哔哩
     */
    private String bilibili;
    /**
     * QQ
     */
    private String qq;
    /**
     * 是否评论审核 (0否 1是)
     */
    private Integer commentCheck;
    /**
     * 是否留言审核 (0否 1是)
     */
    private Integer messageCheck;
    /**
     * 是否开启打赏 (0否 1是)
     */
    private Integer isReward;
    /**
     * 微信二维码
     */
    private String weiXinCode;
    /**
     * 支付宝二维码
     */
    private String aliCode;
    /**
     * 是否邮箱通知 (0否 1是)
     */
    private Integer emailNotice;
    /**
     * 社交列表
     */
    private String socialList;
    /**
     * 登录方式
     */
    private String loginList;
    /**
     * 是否开启音乐播放器 (0否 1是)
     */
    private Integer isMusic;
    /**
     * 网易云歌单id
     */
    private String musicId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}

