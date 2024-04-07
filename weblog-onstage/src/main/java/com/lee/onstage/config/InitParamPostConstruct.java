package com.lee.onstage.config;

import com.lee.onstage.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 初始化热数据进redis或elastic
 */
@Slf4j
@Component
public class InitParamPostConstruct {

    final  ArticleMapper articleMapper;

    public InitParamPostConstruct(ArticleMapper articleMapper){
        this.articleMapper=articleMapper;
    }

    @PostConstruct
    public void init(){
        log.info("init redis param");
    }

}
