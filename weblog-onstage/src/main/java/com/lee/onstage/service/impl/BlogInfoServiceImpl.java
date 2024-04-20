package com.lee.onstage.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lee.onstage.entity.Article;
import com.lee.onstage.entity.SiteConfig;
import com.lee.onstage.mapper.*;
import com.lee.onstage.model.vo.*;
import com.lee.onstage.service.BlogInfoService;
import com.lee.onstage.service.BlogRedisService;
import com.lee.onstage.service.SiteConfigService;
import com.lee.onstage.utils.IPUtil;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.utils.UserAgentUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.lee.onstage.constants.RedisConstant.*;

@Service("blogInfoService")
public class BlogInfoServiceImpl implements BlogInfoService {
    private final ArticleMapper articleMapper;

    private final CategoryMapper categoryMapper;

    private final TagMapper tagMapper;

    private final SiteConfigService siteConfigService;

    private final MessageMapper messageMapper;

    private final UserMapper userMapper;

    private final VisitLogMapper visitLogMapper;
    private final BlogRedisService redisCache;
    private final HttpServletRequest request;

    public BlogInfoServiceImpl(ArticleMapper articleMapper, CategoryMapper categoryMapper, TagMapper tagMapper, SiteConfigService siteConfigService, MessageMapper messageMapper, UserMapper userMapper, VisitLogMapper visitLogMapper, BlogRedisService redisCache, HttpServletRequest request) {
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
     * 获取博客基本信息
     * @auther Acxfoxer
     * @return BlogInfoVO
     * @Date 2023-08-25
     */
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
        long blogViewCount = Long.parseLong(redisCache.getObject(BLOG_VIEW_COUNT).toString());
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

    /**
     *获取博客后台信息
     * @auther Acxfoxer
     * @return BlogBackInfoVO
     * @Date 2023-08-25
     */
    @Override
    public BlogBackInfoVO getBlogBackInfo() {
        // 标签数据
        List<TagOptionVO> tagList = tagMapper.selectTagList();
        // 文章数量
        Long articleCount = articleMapper.selectCount(new LambdaQueryWrapper<Article>()
                .eq(Article::getStatus, 1).eq(Article::getIsDelete, 0));
        // 分类数据
        List<CategoryVO> categoryVOList = categoryMapper.selectCategoryVOList();
        // 博客访问量
        Long blogViewCount = redisCache.getObject(BLOG_VIEW_COUNT);
        // 用户数量
        Long userCount =userMapper.selectCount(null);
        // 留言量
        Long messageCount=messageMapper.selectCount(null);
        //查询当前时间前一周的用户访问记录
        List<UserViewVO> userViewVOList=visitLogMapper.selectUserViewRecode(DateUtil.offsetDay(new Date(),-7),DateUtil.endOfDay(new Date()));
        //文章统计
        List<ArticleStatisticsVO> articleStatisticsVOList=articleMapper.selectArticleStatistics();
        //查询redis访问量前五的文章
        Map<Object, Double> articleMap = redisCache.getCacheZSetWithScore(ARTICLE_VIEW_COUNT, 0, 4);
        BlogBackInfoVO blogBackInfoVO = BlogBackInfoVO.builder()
                .articleStatisticsList(articleStatisticsVOList)
                .articleCount(articleCount)
                .categoryVOList(categoryVOList)
                .viewCount(blogViewCount)
                .messageCount(messageCount)
                .userCount(userCount)
                .tagVOList(tagList)
                .userViewVOList(userViewVOList)
                .build();
        List<Integer> articleIdList = new ArrayList<>();
        //获取访问量前五的文章id
        if(ObjectUtil.isNotEmpty(articleMap))
            articleMap.keySet().forEach(item->articleIdList.add((Integer) item));
        //根据id查询文章信息,并组装文章排行信息
        List<ArticleRankVO> articleRankVOList = articleMapper.selectByIds(articleIdList)
                .stream()
                .map(item ->
                    ArticleRankVO.builder()
                            .articleTitle(item.getArticleTitle())
                            .viewCount(articleMap.get(item.getId()).intValue())
                            .build()
                ).collect(Collectors.toList());
        blogBackInfoVO.setArticleRankVOList(articleRankVOList);
        return blogBackInfoVO;
        }

    /**
     * get aboutme
     * @auther Acxfoxer
     * @Date 2023-08-25
     * @return String
     */
    @Override
    public String getAbout() {
        return siteConfigService.getSiteConfig().getAboutMe();
    }

    /**
     * 埋点用户访问博客数据
     * @auther Acxfoxer
     * @Date 2023-08-25
     */
    @Override
    public void recordVisitorInfo() {
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
}
