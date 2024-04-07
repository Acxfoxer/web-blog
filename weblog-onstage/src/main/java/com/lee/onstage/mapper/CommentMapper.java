package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Comment;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.CommentVO;
import com.lee.onstage.model.vo.RecentCommentVO;
import com.lee.onstage.model.vo.ReplyCountVO;
import com.lee.onstage.model.vo.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * 获取最近评论
     * @return
     */
    List<RecentCommentVO> selectRecentComments();

    /**
     * 查询父评论内容
     * @param limit 限制条数
     * @param pageParamDto 查询条件
     * @return
     */
    List<CommentVO> selectParentComment(@Param("limit") int limit, @Param("size")int size, PageParamDto pageParamDto);

    /**
     * 查询父评论对应的子评论
     * @param parentCommentIdList 父评论Id
     * @return
     */
    List<ReplyVO> selectChildComment(List<Integer> parentCommentIdList);

    List<ReplyCountVO> selectReplyCount(List<Integer> parentCommentIdList);
}

