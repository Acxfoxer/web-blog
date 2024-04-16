package com.lee.onstage.producer;

import com.alibaba.fastjson2.JSON;
import com.lee.onstage.model.dto.EmailDto;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

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
