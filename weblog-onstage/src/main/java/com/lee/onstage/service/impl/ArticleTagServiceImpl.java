package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.entity.ArticleTag;
import com.lee.onstage.mapper.ArticleTagMapper;
import com.lee.onstage.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * (ArticleTag)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

}

