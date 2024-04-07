package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Comment;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.CommentVO;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.RecentCommentVO;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
public interface CommentService extends IService<Comment> {

    /**
     * 获取最近的评论数
     * @return
     */
    List<RecentCommentVO> listRecentComments();

    PageResult<CommentVO> listCommentsByArticleId(PageParamDto pageParamDto);
}

