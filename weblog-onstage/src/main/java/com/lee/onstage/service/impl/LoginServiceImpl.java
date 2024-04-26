package com.lee.onstage.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.lee.onstage.constants.*;
import com.lee.onstage.entity.Role;
import com.lee.onstage.entity.SiteConfig;
import com.lee.onstage.entity.User;
import com.lee.onstage.entity.UserRole;
import com.lee.onstage.mapper.UserMapper;
import com.lee.onstage.mapper.UserRoleMapper;
import com.lee.onstage.model.dto.EmailDto;
import com.lee.onstage.model.dto.UserRegisterDto;
import com.lee.onstage.producer.KafkaProducer;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.BlogRedisService;
import com.lee.onstage.service.EmailService;
import com.lee.onstage.utils.CommonUtils;
import com.lee.onstage.utils.IPUtil;
import com.lee.onstage.utils.MyRedisCache;
import com.lee.onstage.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.lee.onstage.constants.RedisConstant.SITE_SETTING;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private BlogRedisService redisCache;
    @Resource
    private KafkaProducer kafkaProducer;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 登录方法
     * @param user 登录用户
     * @return ResponseResult
     */
    @Override
    public ResponseResult<?> login(User user) {
        //generate authenticationToken
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        return null;
    }

    /**
     * 登出
     * @return ResponseResult
     */
    @Override
    public ResponseResult<?> logout() {
        return null;
    }

    /**
     * 发送验证码
     * @param email 邮箱地址
     * @author Acxfoxer
     * @Date 20240415
     */
    @Override
    public void sendCode(String email) {
        //校验验证码是否正确
        Assert.isTrue(CommonUtils.checkEmail(email),"邮箱地址有误");
        //获得随机6位数字验证码
        RandomGenerator captcha = new RandomGenerator("0123456789",6);
        HashMap<String,Object> contentMap= new HashMap<>();
        String code = captcha.generate();
        contentMap.put("code", code);
        contentMap.put("name",email);
        contentMap.put("title",CommonConstant.REGISTER_TITLE);
        //组装发送参数
        EmailDto emailDto = EmailDto
                .builder()
                .contentMap(contentMap)
                .emailAccounts(Collections.singletonList(email))
                .subject(CommonConstant.CAPTCHA)
                .template(CommonConstant.REGISTER_TEMPLATE)
                .build();
        //发送到消息队列
        kafkaProducer.send(KafkaConstants.EMAIL,emailDto);
        //将验证码存入redis缓存中
        redisCache.setCacheObject(RedisConstant.CODE_KEY+email,code,RedisConstant.CODE_EXPIRE_TIME, TimeUnit.MINUTES);
    }

    /**
     * 新用户注册
     *
     * @param userRegisterDto 用户注册信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(UserRegisterDto userRegisterDto, HttpServletRequest servletRequest) {
        verifyCode(userRegisterDto.getCode(),userRegisterDto.getUsername());
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, userRegisterDto.getUsername()));
        Assert.isNull(user,"邮箱已被注册");
        SiteConfig siteConfig = redisCache.getObject(SITE_SETTING);
        User newUser = User.builder()
                .avatar(siteConfig.getUserAvatar())
                .email(userRegisterDto.getUsername())
                .username(userRegisterDto.getUsername())
                .ipAddress(IPUtil.getIpAddr(servletRequest))
                .password(userRegisterDto.getPassword())
                .nickname(CommonConstant.USER_NICKNAME + IdWorker.getId())
                .isDisable(0)
                .loginType(LoginTypeEnum.EMAIL.getLoginType())
                .build();
        userMapper.insert(newUser);
        // 绑定用户角色
        UserRole userRole = UserRole.builder()
                .userId(newUser.getId())
                .roleId(RoleEnum.USER.getRoleId())
                .build();
        userRoleMapper.insert(userRole);
    }

    /**
     * 校验验证码
     * @param code 验证码
     * @param userName  用户名
     */
    private void verifyCode(String code, String userName) {
        String cacheCode = redisCache.getCacheObject(RedisConstant.CODE_KEY+userName);
        Assert.notBlank(cacheCode,"验证码未发送或已过期");
        Assert.isTrue(code.equals(cacheCode),"验证码不正确,请重新输入");
    }
}
