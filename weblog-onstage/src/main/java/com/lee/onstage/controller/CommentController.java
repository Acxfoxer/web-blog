package com.lee.onstage.controller;

import com.lee.onstage.annotation.VisitLogger;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.CommentVO;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.RecentCommentVO;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "评论功能")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource(name = "commentService")
    CommentService commentService;
    @ApiOperation(value = "获取最近评论内容")
    @GetMapping("/recent")
    public ResponseResult<List<RecentCommentVO>> getRecentComments(){
        return ResponseResult.success(commentService.listRecentComments());
    }
    @VisitLogger("获取对应文章评论内容")
    @ApiOperation(value = "获取文章对应评论内容")
    @GetMapping("/list")
    public ResponseResult<PageResult<CommentVO>> listCommentByArticleId(PageParamDto pageParamDto){
        return ResponseResult.success(commentService.listCommentsByArticleId(pageParamDto));
    }
}
