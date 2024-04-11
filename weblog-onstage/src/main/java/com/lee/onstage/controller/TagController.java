package com.lee.onstage.controller;

import com.lee.onstage.annotation.VisitLogger;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.*;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class TagController {
    @Resource
    private TagService tagService;

    @ApiOperation(value = "查看后台标签")
    @GetMapping("/admin/tag/list")
    public ResponseResult<PageResult<TagBackVO>> listTagBackVO(PageParamDto pageParamDto){
        return ResponseResult.success(tagService.listTagBackVO(pageParamDto));
    }
    @ApiOperation("查看文件标签")
    @VisitLogger("查看文章标签")
    @GetMapping("/tag/list")
    public ResponseResult<List<TagVO>> listTagVO(){
        return ResponseResult.success(tagService.listTagVO());
    }

    @VisitLogger("查看对应标签的文章")
    @ApiOperation(value = "查看该标签下的文章")
    @GetMapping("/tag/article")
    public ResponseResult<ArticleConditionList> listArticleVOByTag(PageParamDto pageParamDto){
        return ResponseResult.success(tagService.listArticleVOByTag(pageParamDto));
    }
}
