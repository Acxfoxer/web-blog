package com.lee.onstage.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.RedisConstant;
import com.lee.onstage.constants.ResultCode;
import com.lee.onstage.entity.Article;
import com.lee.onstage.mapper.ArticleMapper;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.ArticleBackVO;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * (Article)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Resource
    private MyRedisCache redisCache;
    @Resource
    private ArticleMapper articleMapper;
    /**
     * 查询热门文章,以浏览量,点赞量进行计算
     * 热度算法 新闻热度分 = 初始热度分 + 用户交互产生的热度分 – 随时间衰减的热度分
     * Score = S0 + S(Users) – S(Time)
     * S(Users) = 1*click + 5*favor + 10*comment + 20*share
     * 点击,收藏,分享,评论
     * 默认代码计算结果取前十条
     * @return
     */
    @ApiOperation("查询")
    @Override
    public ResponseResult getHotArticle() {
        //查询redis中热门文章最高的文章id
        Set<Integer> cacheZSet = redisCache.getCacheZSet(RedisConstant.HOT_KEY, 0, -1);
        if(ObjectUtil.isNotNull(cacheZSet)){
            //存在直接根据id查询
            List<Article> articles = articleMapper.selectBatchIds(cacheZSet);
            return ResponseResult.success(ResultCode.SUCCESS.getValue(),ResultCode.SUCCESS.getMsg(),articles);
        }
        return null;
    }

    /**
     * 分页查询
     * @param
     * @return
     */
    @Override
    public ResponseResult getArticleList(PageParamDto param) {
        IPage<ArticleBackVO> page = new Page<>(param.getCurrent(),param.getSize());

        //不存在,重新查询并算分
        //重新从redis中获取浏览量
        Map<Object, Double> viewCountMap = redisCache.getCacheAllZSet(RedisConstant.ARTICLE_VIEW_COUNT,0,10);
        //从redis中获取文章点赞量
        Map<String, Integer> clickMap = redisCache.getHashAll(RedisConstant.ARTICLE_CLICK_COUNT);
        List<ArticleBackVO> articles = articleMapper.selectHotArticle();
        // 封装文章后台信息
        articles.forEach(item -> {
            Double viewCount = Optional.ofNullable(viewCountMap.get(item.getId())).orElse((double) 0);
            item.setViewCount(viewCount.intValue());
            Integer likeCount = clickMap.get(item.getId().toString());
            item.setLikeCount(Optional.ofNullable(likeCount).orElse(0));
        });
        page.setRecords(articles);
        return ResponseResult.success(ResultCode.SUCCESS.getValue(),"",page);
    }
}

