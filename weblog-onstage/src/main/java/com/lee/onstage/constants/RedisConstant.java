package com.lee.onstage.constants;

/**
 * Redis常量
 *
 * @author ican
 */
public class RedisConstant {
    /**
     * 登录
     */
    public static final String LOGIN_KEY="blog:user:login";

    public static final String HOT_KEY="blog:hot_article";
    /**
     * 验证码 key
     */
    public static final String CODE_KEY = "blog:code:";

    /**
     * 验证码过期时间
     */
    public static final Integer CODE_EXPIRE_TIME = 2;

    /**
     * 文章浏览量
     */
    public static final String ARTICLE_VIEW_COUNT = "blog:article_view_count";

    /**
     * 文章点赞量
     */
    public static final String ARTICLE_CLICK_COUNT = "blog:article_click_count";
    /**
     * 文章收藏数
     */
    public static final String ARTICLE_COLLECTION= "blog:article_collection";

    /**
     * 文章评论量
     */
    public static final String ARTICLE_COMMENT_COUNT="blog:article_comment_count";

    /**
     * 说说点赞量
     */
    public static final String TALK_LIKE_COUNT = "blog:talk_like_count";

    /**
     * 评论点赞量
     */
    public static final String COMMENT_LIKE_COUNT = "blog:comment_like_count";

    /**
     * 用户点赞文章
     */
    public static final String USER_ARTICLE_LIKE = "blog:user_article_like:";

    /**
     * 用户点赞评论
     */
    public static final String USER_COMMENT_LIKE = "blog:user_comment_like:";

    /**
     * 用户点赞说说
     */
    public static final String USER_TALK_LIKE = "blog:user_talk_like:";

    /**
     * 网站配置
     */
    public static final String SITE_SETTING = "blog:site_setting";

    /**
     * 访客
     */
    public static final String UNIQUE_VISITOR = "blog:unique_visitor";

    /**
     * 博客浏览量
     */
    public static final String BLOG_VIEW_COUNT = "blog:blog_view_count";

}