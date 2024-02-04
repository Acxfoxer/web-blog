package com.lee.onstage.controller;

import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.ArticleHomeVO;
import com.lee.onstage.model.vo.ArticleRecommendVO;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "文章模块")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @ApiOperation(value = "文章分页查询")
    @GetMapping("/articleList")
    public ResponseResult<PageResult<ArticleHomeVO>> getArticleList(PageParamDto param){
        return ResponseResult.success(articleService.getArticleList(param));
    }

    @ApiOperation(value = "文章推荐")
    @GetMapping("/recommend")
    public ResponseResult<List<ArticleRecommendVO>> getRecommend(){
        return ResponseResult.success(articleService.getRecommend());
    }

}
