package com.lee.onstage.mapStruct;

import com.lee.onstage.entity.Article;
import com.lee.onstage.model.vo.ArticleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleConvertMapper {
    ArticleConvertMapper INSTANCE=Mappers.getMapper(ArticleConvertMapper.class);
    ArticleVO toArticleVO(Article article);
    Article toArticle(ArticleVO articleVO);
}
