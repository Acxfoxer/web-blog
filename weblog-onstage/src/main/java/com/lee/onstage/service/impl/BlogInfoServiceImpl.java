package com.lee.onstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lee.onstage.entity.Article;
import com.lee.onstage.entity.SiteConfig;
import com.lee.onstage.mapper.*;
import com.lee.onstage.model.vo.BlogBackInfoVO;
import com.lee.onstage.model.vo.BlogInfoVO;
import com.lee.onstage.service.BlogInfoService;
import com.lee.onstage.service.SiteConfigService;
import com.lee.onstage.utils.IPUtil;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.utils.UserAgentUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.lee.onstage.constants.RedisConstant.BLOG_VIEW_COUNT;
import static com.lee.onstage.constants.RedisConstant.UNIQUE_VISITOR;

@Service
public class BlogInfoServiceImpl implements BlogInfoService {
    private final ArticleMapper articleMapper;

    private final CategoryMapper categoryMapper;

    private final TagMapper tagMapper;

    private final SiteConfigService siteConfigService;

    private final MessageMapper messageMapper;

    private final UserMapper userMapper;

    private final VisitLogMapper visitLogMapper;
    private final MyRedisCache redisCache;
    private final HttpServletRequest request;

    public BlogInfoServiceImpl(ArticleMapper articleMapper, CategoryMapper categoryMapper, TagMapper tagMapper, SiteConfigService siteConfigService, MessageMapper messageMapper, UserMapper userMapper, VisitLogMapper visitLogMapper, MyRedisCache redisCache, HttpServletRequest request) {
        this.articleMapper = articleMapper;
        this.categoryMapper = categoryMapper;
        this.tagMapper = tagMapper;
        this.siteConfigService = siteConfigService;
        this.messageMapper = messageMapper;
        this.userMapper = userMapper;
        this.visitLogMapper = visitLogMapper;
        this.redisCache = redisCache;
        this.request = request;
    }

    /**
     * 埋点用户访问博客数据
     */
    @Override
    public void report() {
        //获取当前用户iP
        String ipAddress = IPUtil.getIpAddr(request);
        //解析用户客户端操作系统和浏览器版本
        Map<String, String> userAgentMap = UserAgentUtils.parseOsAndBrowser(request.getHeader("User-Agent"));
        //获取访问设备信息
        String browser = userAgentMap.get("browser");
        String os = userAgentMap.get("os");
        //生成用户唯一标识
        String uuid = ipAddress+browser+os;
        //对唯一标识进行MD5加密
        String md5 = DigestUtils.md5DigestAsHex(uuid.getBytes());
        // 判断是否访问
        if(!redisCache.hasSetValue(UNIQUE_VISITOR,md5)){
            //访问量加一
            redisCache.incr(BLOG_VIEW_COUNT,1);
            //保存唯一标识
            redisCache.setSet(UNIQUE_VISITOR,md5);
        }
    }

    @Override
    public BlogInfoVO getBlogInfo() {
        // 文章数量
        Long articleCount = articleMapper.selectCount(new LambdaQueryWrapper<Article>()
                .eq(Article::getStatus, 1).eq(Article::getIsDelete, 0));
        // 分类数量
        Long categoryCount= categoryMapper.selectCount(null);
        // 标签数量
        Long tagCount = tagMapper.selectCount(null);
        // 博客访问量
        Long blogViewCount = redisCache.getObject(BLOG_VIEW_COUNT);
        // 网站配置
        SiteConfig siteConfig = siteConfigService.getSiteConfig();
        //构造返回参数
        return BlogInfoVO.builder()
                .siteConfig(siteConfig)
                .articleCount(articleCount)
                .categoryCount(categoryCount)
                .tagCount(tagCount)
                .viewCount(blogViewCount)
                .build();
    }

    @Override
    public BlogBackInfoVO getBlogBackInfo() {
        return null;
    }

    @Override
    public String getAbout() {
        return null;
    }
}
