package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.BlogFileMapper;
import com.lee.onstage.entity.BlogFile;
import com.lee.onstage.service.BlogFileService;
import org.springframework.stereotype.Service;

/**
 * (BlogFile)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("blogFileService")
public class BlogFileServiceImpl extends ServiceImpl<BlogFileMapper, BlogFile> implements BlogFileService {

}

