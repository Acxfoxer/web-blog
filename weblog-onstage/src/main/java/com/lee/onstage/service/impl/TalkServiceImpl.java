package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.ArticleConstants;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.mapper.TalkMapper;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.TalkVO;
import com.lee.onstage.service.TalkService;
import com.lee.onstage.utils.MyRedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public TalkServiceImpl(TalkMapper talkMapper, MyRedisCache redisCache) {
        this.talkMapper = talkMapper;
        this.redisCache = redisCache;
    }

    @Override
    public PageResult<TalkVO> listTalkVO(int current, int size) {
        //获取总数
        Long totalCount = talkMapper.selectCount(new LambdaQueryWrapper<Talk>()
                .eq(Talk::getStatus, ArticleConstants.PUBLIC.getCode()));
        if(totalCount==0){
            return new PageResult<>();
        }
        //分页查询
        List<TalkVO> talkVOList = talkMapper.selectTalkList((current-1)*size,size);
        //获取点赞量
        long likeCount = Long.parseLong(redisCache.getObject(TALK_LIKE_COUNT).toString());
        //获取评论量
        long commentCount= Long.parseLong(redisCache.getObject(COMMENT_LIKE_COUNT).toString());

        return  new PageResult<>(talkVOList,totalCount);
    }
}

