package com.lee.onstage.service;

import com.lee.onstage.model.vo.BlogBackInfoVO;
import com.lee.onstage.model.vo.BlogInfoVO;

public interface BlogInfoService {

    /**
     * 查看博客信息
     *
     * @return 博客信息
     */
    BlogInfoVO getBlogInfo();

    /**
     * 查看博客后台信息
     *
     * @return 博客后台信息
     */
    BlogBackInfoVO getBlogBackInfo();

    /**
     * 查看关于我信息
     *
     * @return 关于我信息
     */
    String getAbout();

    /**
     * 记录访客信息
     */
    void recordVisitorInfo();
}
