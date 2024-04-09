package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.constants.ArticleConstants;
import com.lee.onstage.constants.CommonConstant;
import com.lee.onstage.constants.RedisConstant;
import com.lee.onstage.entity.Article;
import com.lee.onstage.mapper.ArticleMapper;
import com.lee.onstage.mapperStruct.ArticleConvertMapper;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.*;
import com.lee.onstage.service.ArticleService;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.utils.PageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * (Article)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    private static final Integer DEFAULT=0;
    @Resource
    private MyRedisCache redisCache;
    @Resource
    private ArticleMapper articleMapper;
    /**
     * 查询热门文章,以浏览量,点赞量进行计算
     * 文章热度分 = 初始热度分 + 用户交互产生的热度分 – 随时间衰减的热度分
     * Score = S0 + S(Users) – S(Time)
     * S(Users) = 1*click + 5*favor + 10*comment + 20*share
     * 点击,收藏,分享,评论
     * 默认代码计算结果取前十条
     * @return
     */
    @ApiOperation("查询")
    @Override
    public List<ArticleRecommendVO> getRecommend() {
        //查询redis中热门文章最高的文章id
        Set<Long> cacheZSet = redisCache.getCacheZSet(RedisConstant.HOT_KEY, 0, -1);
        if(cacheZSet.size()>0){
            //存在直接根据id查询
            List<Article> articles = articleMapper.selectBatchIds(cacheZSet);
            List<ArticleRecommendVO> articleRecommendVOS = articles.stream().map(item -> {
                ArticleRecommendVO articleRecommendVO = new ArticleRecommendVO();
                BeanUtils.copyProperties(item, articleRecommendVO);
                return articleRecommendVO;
            }).collect(Collectors.toList());
            return articleRecommendVOS;
        }else {
            List<ArticleBackVO> articles = articleMapper.selectAll();
            List<ArticleRecommendVO> collect = articles.stream().map(item -> {
                ArticleRecommendVO articleRecommendVO = new ArticleRecommendVO();
                BeanUtils.copyProperties(item, articleRecommendVO);
                return articleRecommendVO;
            }).collect(Collectors.toList());
            return collect;
        }

    }

    /**
     * 获得文章归档数据结果
     * @param pageParamDto 查询条件
     * @return
     */
    @Override
    public PageResult<ArchiveVO> getArchiveVO(PageParamDto pageParamDto) {
        Long articleTotalCount = articleMapper.selectCount(new LambdaQueryWrapper<Article>()
                .eq(Article::getIsDelete, CommonConstant.FALSE)
                .eq(Article::getStatus, ArticleConstants.PUBLIC.getCode()));
        List<ArchiveVO> archiveVOList = articleMapper.selectArchiveVO(PageUtils.getLimit(pageParamDto),PageUtils.getSize(pageParamDto));
        return new PageResult<>(archiveVOList,articleTotalCount);
    }

    @Override
    public ArticleVO getArticleVO(String articleId) {
        //db 查询articleVO
        ArticleVO articleVO = articleMapper.selectArticleVO(articleId);
        if(articleVO==null){
            return null;
        }
        //浏览量加一
        int viewCount = Integer.parseInt(redisCache.incrZSet(RedisConstant.ARTICLE_VIEW_COUNT, articleId, 1d).toString());
        //获取点赞量
        int likeCount = getCacheCount(RedisConstant.ARTICLE_Like_COUNT,articleId,articleVO.getLikeCount());
        //获取收藏量
        int collectCount = getCacheCount(RedisConstant.ARTICLE_COLLECTION,articleId,articleVO.getCollectCount());
        compareAndUpdateDB(articleVO,likeCount,collectCount);
        articleVO.setViewCount(viewCount);
        articleVO.setLikeCount(likeCount);
        articleVO.setCollectCount(collectCount);
        //获取上一篇文章
        ArticlePaginationVO preArticle = articleMapper.selectPreArticle(articleId);
        //获取下一篇文章
        ArticlePaginationVO postArticle = articleMapper.selectPostArticle(articleId);
        articleVO.setPreArticle(preArticle);
        articleVO.setPostArticle(postArticle);
        return articleVO;
    }

    /**
     * 比较并更新db中的值
     * @param articleVO
     * @param likeCount
     * @param collectCount
     */
    @Transactional
    public void compareAndUpdateDB(ArticleVO articleVO, int likeCount, int collectCount) {
        Article article = ArticleConvertMapper.INSTANCE.toArticle(articleVO);
        if(articleVO.getLikeCount()!=likeCount){
            article.setLikeCount(likeCount);
        }
        if(articleVO.getCollectCount()!=collectCount){
            article.setCollectCount(collectCount);
        }
        articleMapper.updateById(article);
    }

    /**
     * 获取缓存中缓存的值
     * @param key
     * @param articleId
     * @param dbCount
     * @return
     */
    private int getCacheCount(String key, String articleId,Integer dbCount) {
        double cacheZSetScore = redisCache.getCacheZSetScore(key, articleId);
        int compareDBResCount= dbCount==null?DEFAULT:dbCount;
        if(cacheZSetScore==0){
            redisCache.setCacheZSet(key,articleId,compareDBResCount);
            return compareDBResCount;
        }
        return (int)cacheZSetScore;
    }


    /**
     * 分页查询
     * @param
     * @return
     */
    @Override
    public PageResult<ArticleHomeVO> getArticleList(PageParamDto param) {
        LambdaQueryWrapper<Article> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Article::getIsDelete, CommonConstant.FALSE)
                .eq(Article::getStatus, ArticleConstants.PUBLIC.getCode());
        Long total = articleMapper.selectCount(lqw);
        Integer limit = (param.getCurrent()-1)*param.getCurrent();
        List<ArticleHomeVO> articleHomeVOS = articleMapper.selectArticleHomeList(limit,param.getSize());
        return new PageResult<>(articleHomeVOS,total);
    }
}

