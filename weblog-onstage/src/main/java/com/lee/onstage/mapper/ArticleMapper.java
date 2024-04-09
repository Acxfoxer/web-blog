package com.lee.onstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.onstage.entity.Article;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    List<Article> getPageList(@Param("param") PageParamDto param);

    List<ArticleBackVO> selectHotArticle();

    List<ArticleBackVO> selectAll();

    List<ArticleBackVO> selectByIds(List<Integer> ids);

    List<ArticleStatisticsVO> selectArticleStatistics();

    List<ArticleHomeVO> selectArticleHomeList(Integer limit, Integer size);

    List<ArchiveVO> selectArchiveVO(@Param("limit") int limit, @Param("size") Integer size);

    ArticleVO selectByArticleId(String articleId);

    ArticleVO selectArticleVO(String articleId);

    /**
     * 查询前一文章
     * @param articleId
     * @return
     */
    ArticlePaginationVO selectPreArticle(String articleId);

    /**
     * 查询后一文章
     * @param articleId
     * @return
     */
    ArticlePaginationVO selectPostArticle(String articleId);
}

