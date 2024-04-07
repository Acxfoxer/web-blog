package com.lee.onstage.utils;

import com.lee.onstage.model.dto.PageParamDto;

import java.util.Optional;

/**
 * 分页工具类
 * @author Acxfoxer
 */
public class PageUtils {
    private static final Integer DEFAULT_SIZE=10;
    private static final Integer DEFAULT_CURRENT_PAGE=1;
    public static int getLimit(PageParamDto pageParamDto){
        Integer current = Optional.ofNullable(pageParamDto.getCurrent()).orElse(DEFAULT_CURRENT_PAGE);
        return getSize(pageParamDto)*(current-1);
    }

    /**
     * 没有则默认为10
     * @param pageParamDto
     * @return
     */
    public static int getSize(PageParamDto pageParamDto){
        return Optional
                .ofNullable(pageParamDto.getSize())
                .orElse(DEFAULT_SIZE);
    }
}
