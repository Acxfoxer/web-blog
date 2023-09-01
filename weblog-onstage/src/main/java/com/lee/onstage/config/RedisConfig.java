package com.lee.onstage.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Data
@Aspect
@ConfigurationProperties(prefix = "spring.redis")
@Slf4j
public class RedisConfig {

    /**
     * redisTemplate实例,改变序列号方式
     * @auther  acxfoxer
     * @Date 2023-08-31
     */
    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        // 1.创建RedisTemplate对象
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        // 2.加载Redis配置
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        // 3.配置key序列化
        RedisSerializer<?> stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // 4.配置Value序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objMapper.activateDefaultTyping(objMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objMapper);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        // 5.初始化RedisTemplate
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 限流脚本
     * @return
     */
    @Bean
    public DefaultRedisScript<Long> limitScript()
    {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(limitScriptText());
        redisScript.setResultType(Long.class);
        return redisScript;
    }
    /**
     * 限流脚本
     */
    private String limitScriptText()
    {
        return "local key = KEYS[1]\n" +
                "local count = tonumber(ARGV[1])\n" +
                "local time = tonumber(ARGV[2])\n" +
                "local current = redis.call('get', key);\n" +
                "if current and tonumber(current) > count then\n" +
                "    return tonumber(current);\n" +
                "end\n" +
                "current = redis.call('incr', key)\n" +
                "if tonumber(current) == 1 then\n" +
                "    redis.call('expire', key, time)\n" +
                "end\n" +
                "return tonumber(current);";
    }
}
