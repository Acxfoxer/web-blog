package com.lee.onstage.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import javax.annotation.Resource;

/**
 * kafka配置类
 */
@Configuration
@Slf4j
public class KafkaConfig {
    @Resource
    private KafkaProperties kafkaProperties;
    @Bean
    public JsonMessageConverter jsonMessageConverter() {
        return new ByteArrayJsonMessageConverter();
    }
    @Bean
    public KafkaListenerErrorHandler myTopicErrorHandler() {
        return (m, e) -> {
            log.error("Got an error {}", e.getMessage());
            return "some info about the failure";
        };
    }
}
