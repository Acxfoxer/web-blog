package com.lee.onstage.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.TypeReference;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.ArticleConstants;
import com.lee.onstage.constants.CommentConstants;
import com.lee.onstage.constants.CommonConstant;
import com.lee.onstage.constants.RedisConstant;
import com.lee.onstage.entity.Comment;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.mapper.CommentMapper;
import com.lee.onstage.mapper.TalkMapper;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.CommentCountVO;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.TalkVO;
import com.lee.onstage.service.TalkService;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.utils.PageUtils;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lee.onstage.constants.RedisConstant.*;
/**
 * (Talk)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("talkService")
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {
    private final TalkMapper talkMapper;
    private final MyRedisCache redisCache;

    private final CommentMapper commentMapper;

    public TalkServiceImpl(TalkMapper talkMapper, MyRedisCache redisCache, CommentMapper commentMapper) {
        this.talkMapper = talkMapper;
        this.redisCache = redisCache;
        this.commentMapper = commentMapper;
    }

    @Override
    public PageResult<TalkVO> listTalkVO(PageParamDto pageParamDto) {
        //获取总数
        Long totalCount = talkMapper.selectCount(new LambdaQueryWrapper<Talk>()
                .eq(Talk::getStatus, ArticleConstants.PUBLIC.getCode()));
        if(totalCount==0){
            return new PageResult<>();
        }
        //分页查询
        List<TalkVO> talkVOList = talkMapper.selectTalkList(PageUtils.getLimit(pageParamDto),PageUtils.getSize(pageParamDto));
        //获取评论量
        List<Long> talkIds = talkVOList.stream().map(TalkVO::getId).collect(Collectors.toList());
        List<CommentCountVO> commentCountVOList =commentMapper.selectCommentCountMap(talkIds,
                CommentConstants.NORMAL.getCode(),CommentConstants.TALK_TYPE.getCode());
        //转变为评论Map集合
        Map<Long, Integer> commentCountMap = commentCountVOList
                .stream()
                .collect(Collectors
                        .toMap(CommentCountVO::getId, CommentCountVO::getCommentCount));
        //获取点赞量
        Map<String, Integer> likeCountMap = redisCache.getHashAll(TALK_LIKE_COUNT);
        talkVOList.forEach(item->{
            item.setLikeCount(Optional.ofNullable(likeCountMap.get(item.getId().toString())).orElse(0));
            item.setCommentCount(Optional.ofNullable(commentCountMap.get(item.getId())).orElse(0));
            //将images转变为json字符串
            if(StringUtils.isNotBlank(item.getImages()))
                item.setImgList(JSON.parseArray(item.getImages(), String.class));
        });
        //获取评论量
        return  new PageResult<>(talkVOList,totalCount);
    }

    @Override
    public TalkVO listTalkVOById(String id) {
        //获取说说点赞量
        Integer likeCount = redisCache.getHash(TALK_LIKE_COUNT, id);
        //获取评论量
        Long commentCount = commentMapper.selectCount(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getTalkId, id)
                .eq(Comment::getCommentType, CommentConstants.TALK_TYPE.getCode())
                .eq(Comment::getCommentStatus, CommentConstants.NORMAL.getCode()));
        TalkVO talkVO = talkMapper.selectTalkById(id);
        talkVO.setLikeCount(likeCount);
        talkVO.setCommentCount(commentCount.intValue());
        if(StringUtils.isNotBlank(talkVO.getImages())){
            talkVO.setImgList(JSON.parseArray(talkVO.getImages(),String.class));
        }
        return talkVO;
    }
}

