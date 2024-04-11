package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.Tag;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.*;

import java.util.List;

/**
 * (Tag)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
public interface TagService extends IService<Tag> {

    PageResult<TagBackVO> listTagBackVO(PageParamDto pageParamDto);

    List<TagVO> listTagVO();

    ArticleConditionList listArticleVOByTag(PageParamDto pageParamDto);
}


