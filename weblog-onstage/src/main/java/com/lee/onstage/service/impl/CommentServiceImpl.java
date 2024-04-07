package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.CommonConstant;
import com.lee.onstage.constants.RedisConstant;
import com.lee.onstage.mapper.CommentMapper;
import com.lee.onstage.entity.Comment;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.*;
import com.lee.onstage.service.CommentService;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * (Comment)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private MyRedisCache redisCache;
    /**
     * 获取最近评论
     * @return
     */
    @Override
    public  List<RecentCommentVO> listRecentComments() {
        return commentMapper.selectRecentComments();
    }

    /**
     * 获取文章
     * @param pageParamDto
     * @return
     */
    @Override
    public PageResult<CommentVO> listCommentsByArticleId(PageParamDto pageParamDto) {
        //获取父评论数量
        Long commentCount = commentMapper.selectCount(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getIsCheck, CommonConstant.TRUE)
                .eq(pageParamDto != null, Comment::getTypeId, pageParamDto.getTypeId())
                .eq(Comment::getCommentType, pageParamDto.getCommentType())
                .isNull(Comment::getParentId));
        if(commentCount==0){
            return new PageResult<>(null, 0L);
        }
        //分页查询父评论
        List<CommentVO> parentCommentVOList = commentMapper.selectParentComment(PageUtils.getLimit(pageParamDto)
                ,PageUtils.getSize(pageParamDto),pageParamDto);
        //获取父评论id
        List<Integer> parentCommentIdList = parentCommentVOList.stream().map(CommentVO::getId).collect(Collectors.toList());
        //获取其他参数,例如评论点赞数
        Map<String,Integer> commentLikeMap = redisCache.getHashAll(RedisConstant.COMMENT_LIKE_COUNT);
        //查询父评论对应的子评论内容
        List<ReplyVO> childCommentVOList = commentMapper.selectChildComment(parentCommentIdList);
        //封装子评论点赞量
        childCommentVOList.forEach(item->
                item.setLikeCount(Optional.ofNullable(commentLikeMap.get(item.getId().toString())).orElse(0)));
        //获取父评论对应子评论数量
        List<ReplyCountVO> childCountVOList = commentMapper.selectReplyCount(parentCommentIdList);
        //将回复评论及数量转变为 k v map,k 为parentCommentId
        Map<Integer, List<ReplyVO>> childCommentVOMap = childCommentVOList.stream().collect(Collectors.groupingBy(ReplyVO::getParentId));
        Map<Integer, Integer> childCountMap = childCountVOList.stream().collect(Collectors.toMap(ReplyCountVO::getCommentId, ReplyCountVO::getReplyCount));
        parentCommentVOList.forEach(item->{
            item.setReplyCount(Optional.ofNullable(childCountMap.get(item.getId())).orElse(0));
            item.setLikeCount(Optional.ofNullable(commentLikeMap.get(item.getId().toString())).orElse(0));
            item.setReplyVOList(Optional.ofNullable(childCommentVOMap.get(item.getId())).orElse(new ArrayList<>()));
        });
        //组装结果
        return new PageResult<>(parentCommentVOList,commentCount);
    }
}

