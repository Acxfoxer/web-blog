package com.lee.onstage.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleConstants {
    /**
     * 公开
     */
    PUBLIC(1,"公开"),

    /**
     *  私密
     */
    SECRET(2,"私密"),

    /**
     * 草稿
     */
    DRAFT(3,"草稿");
    private final Integer code;
    private final String msg;
}
