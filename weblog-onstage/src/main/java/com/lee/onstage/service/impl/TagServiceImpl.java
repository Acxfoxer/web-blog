package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.TagMapper;
import com.lee.onstage.entity.Tag;
import com.lee.onstage.service.TagService;
import org.springframework.stereotype.Service;

/**
 * (Tag)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}

