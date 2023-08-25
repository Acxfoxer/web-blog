package com.lee.onstage.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.SiteConfigMapper;
import com.lee.onstage.entity.SiteConfig;
import com.lee.onstage.service.SiteConfigService;
import com.lee.onstage.utils.MyRedisCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.lee.onstage.constants.RedisConstant.*;

/**
 * (SiteConfig)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("siteConfigService")
public class SiteConfigServiceImpl extends ServiceImpl<SiteConfigMapper, SiteConfig> implements SiteConfigService {
    @Resource
    private MyRedisCache redisCache;
    @Override
    public SiteConfig getSiteConfig() {
        //从缓存中获取系统配置
        SiteConfig siteConfig = redisCache.getObject(SITE_SETTING);
        if(ObjectUtil.isNull(siteConfig)){
            //从数据库中获取
            siteConfig = baseMapper.selectById(1);
            //将结果存入缓存
            redisCache.setObject(SITE_SETTING,siteConfig);
        }
        return siteConfig;
    }
}

