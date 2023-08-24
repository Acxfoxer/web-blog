package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.TalkMapper;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.service.TalkService;
import org.springframework.stereotype.Service;

/**
 * (Talk)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("talkService")
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {

}

