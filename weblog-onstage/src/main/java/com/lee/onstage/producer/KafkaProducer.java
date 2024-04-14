package com.lee.onstage.producer;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * kafka消息发送端
 * @date: 2024/04/12
 * @version v1.0
 * @author Acxfoxer
 */
@Component
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void send(String topic,Object message){
        String messageJsonStr = JSON.toJSONString(message);
        log.info("send message:{}",message);
        //发送消息
        kafkaTemplate.send(topic,messageJsonStr);
    }
}
