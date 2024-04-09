package com.lee.onstage.mapperStruct;

import com.lee.onstage.entity.Article;
import com.lee.onstage.model.vo.ArticleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticleConvertMapper {
    ArticleConvertMapper INSTANCE=Mappers.getMapper(ArticleConvertMapper.class);
    ArticleVO toArticleVO(Article article);
    Article toArticle(ArticleVO articleVO);
}
