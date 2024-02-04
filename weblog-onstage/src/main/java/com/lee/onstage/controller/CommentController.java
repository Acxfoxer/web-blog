package com.lee.onstage.controller;

import com.lee.onstage.entity.Comment;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.CommentService;
import io.swagger.annotations.Api;
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

    @GetMapping("/recent")
    public ResponseResult<? extends List<? extends Comment>> getRecentComments(){
        return commentService.getRecentComments();
    }
}
