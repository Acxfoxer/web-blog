package com.lee.onstage.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 评论常量枚举类
 * @auther Acxfoxer
 * @Date 2024/4/11
 */
@Getter
@AllArgsConstructor
public enum CommentConstants {
    /**
     * 正常
     */
    NORMAL(1,"正常"),
    /**
     * 本人删除
     */
    DELETE_BY_SELF(2,"本人删除"),
    /**
     * 作者删除
     */
    DELETE_BY_AUTHOR(3,"本人删除"),
    /**
     * 存在违规内容
     */
    ILLEGAL(4,"违规内容"),
    /**
     * 文章类型评论
     */
    ARTICLE_TYPE(1,"文章类型评论"),

    /**
     * 友链类型
     */
    FRIEND_TYPE(2,"友链类型"),

    /**
     * 说说类型
     */
    TALK_TYPE(3,"说说类型评论");
    private final Integer code;
    private final String msg;

}
