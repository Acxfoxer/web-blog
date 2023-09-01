package com.lee.onstage.controller;

import com.lee.onstage.model.vo.BlogInfoVO;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.BlogInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "博客信息模块")
public class BlogInfoController {
    final BlogInfoService blogInfoService;

    public BlogInfoController(BlogInfoService blogInfoService) {
        this.blogInfoService = blogInfoService;
    }

    /**
     * 查看博客信息
     *
     * @return {@link ResponseResult<BlogInfoVO>} 博客信息
     */
    @GetMapping("/getBlogInfo")
    public ResponseResult<BlogInfoVO> getBlogInfo(){
        return ResponseResult.success(blogInfoService.getBlogInfo());
    }
    /**
     * 埋点用户访问博客数据
     * @auther Acxfoxer
     * @Date 2023-08-25
     */
    @PostMapping("/recordVisitorInfo")
    public ResponseResult<?> recordVisitorInfo(){
        blogInfoService.recordVisitorInfo();
        return ResponseResult.success();
    }
}
