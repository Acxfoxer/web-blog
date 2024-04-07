package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.entity.Tag;
import com.lee.onstage.mapper.TagMapper;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.TagBackVO;
import com.lee.onstage.model.vo.TagVO;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.TagService;
import com.lee.onstage.utils.MyRedisCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tag)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:52
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Resource
    private MyRedisCache redisCache;

    @Override
    public PageResult<TagBackVO> listTagBackVO(PageParamDto pageParamDto) {
        //获取标签数量
        Long count = tagMapper.selectCount(new LambdaQueryWrapper<Tag>());
        //查询标签列表
        List<TagBackVO> backVOS = tagMapper.selectTagBackVo(pageParamDto.getSize() * (pageParamDto.getCurrent() - 1), pageParamDto.getSize(), pageParamDto.getKeyword());
        return new PageResult<>(backVOS,count);
    }

    @Override
    public List<TagVO> listTagVO() {
        return tagMapper.selectTagVOList();
    }
}

