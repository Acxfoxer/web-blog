package com.lee.onstage.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Assert;
import com.lee.onstage.constants.CommonConstant;
import com.lee.onstage.constants.KafkaConstants;
import com.lee.onstage.constants.RedisConstant;
import com.lee.onstage.entity.User;
import com.lee.onstage.mapper.UserMapper;
import com.lee.onstage.model.dto.EmailDto;
import com.lee.onstage.model.dto.UserRegisterDto;
import com.lee.onstage.producer.KafkaProducer;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.BlogRedisService;
import com.lee.onstage.service.EmailService;
import com.lee.onstage.utils.CommonUtils;
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
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        contentMap.put("name",CommonConstant.CAPTCHA);
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
    @Override
    public void register(UserRegisterDto userRegisterDto) {
        verifyCode(userRegisterDto.getCode(),userRegisterDto.getUserName());
    }

    /**
     * 校验验证码
     * @param code
     * @param userName
     */
    private void verifyCode(String code, String userName) {

    }
}
