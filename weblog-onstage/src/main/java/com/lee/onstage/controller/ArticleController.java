package com.lee.onstage.controller;

import com.lee.onstage.annotation.VisitLogger;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.*;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
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

    @VisitLogger("查看文件归档内容")
    @ApiOperation(value = "查看文档归档内容")
    @GetMapping("/archives/list")
    public ResponseResult<PageResult<ArchiveVO>> listArchiveVO(@NotNull PageParamDto pageParamDto){
        return ResponseResult.success(articleService.getArchiveVO(pageParamDto));
    }

    @VisitLogger("查看文章")
    @ApiOperation(value = "查看文章")
    @GetMapping("/{id}")
    public ResponseResult<ArticleVO> getArticleById(@PathVariable("id")String articleId){
        return ResponseResult.success(articleService.getArticleVO(articleId));
    }
}
