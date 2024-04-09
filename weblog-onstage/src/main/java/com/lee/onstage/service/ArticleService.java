package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Article;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.*;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
public interface ArticleService extends IService<Article> {
    /**
     * 分页查询
     * @param pageParamDto 查询条件
     * @return
     */
    PageResult<ArticleHomeVO> getArticleList(PageParamDto pageParamDto);

    /**
     * 查询热门文章
     * @return
     */
    List<ArticleRecommendVO> getRecommend();

    /**
     * 查看归档文章
     * @param pageParamDto 查询条件
     * @return
     */
    PageResult<ArchiveVO> getArchiveVO(PageParamDto pageParamDto);

    /**
     * 根据id查询文章
     * @param articleId
     * @return
     */
    ArticleVO getArticleVO(String articleId);
}

