package com.lee.onstage;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.lee.onstage.strategy.StrategyContext;
import com.lee.onstage.strategy.impl.MyStrategyAdd;
import com.lee.onstage.strategy.impl.MyStrategyDivision;
import com.lee.onstage.strategy.impl.MyStrategyMultiply;
import com.lee.onstage.strategy.impl.MyStrategySubtract;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest(classes = OnStageApp.class)
public class OnStageApplicationTest {
    @Resource(name = "redisTemplate")
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test(){
        StrategyContext context = new StrategyContext(new MyStrategyDivision());
        System.out.println(context.executeStrategy(1,2));
        StrategyContext context1= new StrategyContext(new MyStrategySubtract());
        System.out.println(context1.executeStrategy(1,2));
        StrategyContext context2 = new StrategyContext(new MyStrategyAdd());
        System.out.println(context2.executeStrategy(1,2));
        StrategyContext context3 = new StrategyContext(new MyStrategyMultiply());
        System.out.println(context3.executeStrategy(1,2));
    }
    @Test
    void test1(){
        String string = UUID.randomUUID().toString();
        System.out.println(string);
    }
    @Test
    void test2(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTime dateTime = DateUtil.beginOfDay(DateUtil.offsetDay(new Date(), -7));
        DateTime dateTime1 = DateUtil.endOfDay(new Date());
        System.out.println(dateTime);
        System.out.println(dateTime1);
        System.out.println(DateTime.now());
    }
    @Test
    void redisTest(){
        Long test = redisTemplate.opsForSet().add("test", "123");
        System.out.println(test);
    }

}
