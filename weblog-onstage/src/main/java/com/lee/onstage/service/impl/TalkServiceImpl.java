package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.ArticleConstants;
import com.lee.onstage.mapper.TalkMapper;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.TalkVO;
import com.lee.onstage.service.TalkService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Talk)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("talkService")
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {
    @Resource
    private TalkMapper talkMapper;
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
        return  new PageResult<>(talkVOList,totalCount);
    }
}

