package com.lee.onstage.controller;

import com.lee.onstage.model.vo.BlogInfoVO;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.BlogInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "博客信息模块")
public class BlogInfoController {
    @Autowired
    BlogInfoService blogInfoService;

    /**
     * 查看博客信息
     *
     * @return {@link ResponseResult<BlogInfoVO>} 博客信息
     */
    @GetMapping("/getBlogInfo")
    public ResponseResult getBlogInfo(){
        return ResponseResult.success(blogInfoService.getBlogInfo());
    }

}
