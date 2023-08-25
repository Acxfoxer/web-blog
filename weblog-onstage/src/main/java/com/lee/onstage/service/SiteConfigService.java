package com.lee.onstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.onstage.entity.SiteConfig;

/**
 * (SiteConfig)表服务接口
 *
 * @author lee
 * @since 2023-05-07 15:45:53
 */
public interface SiteConfigService extends IService<SiteConfig> {

    SiteConfig getSiteConfig();
}

