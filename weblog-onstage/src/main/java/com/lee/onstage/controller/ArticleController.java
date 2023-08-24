package com.lee.onstage.controller;

import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "文章模块")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @ApiOperation(value = "文章分页查询")
    @GetMapping("/articleList")
    public ResponseResult getArticleList(PageParamDto param){
        return articleService.getArticleList(param);
    }

    @ApiOperation(value = "热点文章查询")
    @GetMapping("/hotArticle")
    public ResponseResult getHotArticle(){
        return articleService.getHotArticle();
    }

    @ApiOperation(value = "文章推荐")
    @GetMapping("/recommend")
    public ResponseResult getRecommend(){
        return ResponseResult.success(0,"测试");
    }

}
