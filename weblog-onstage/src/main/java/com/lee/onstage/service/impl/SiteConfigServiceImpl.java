package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.onstage.mapper.SiteConfigMapper;
import com.lee.onstage.entity.SiteConfig;
import com.lee.onstage.service.SiteConfigService;
import org.springframework.stereotype.Service;

/**
 * (SiteConfig)表服务实现类
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
@Service("siteConfigService")
public class SiteConfigServiceImpl extends ServiceImpl<SiteConfigMapper, SiteConfig> implements SiteConfigService {

}

