package com.lee.onstage.listener;

import com.lee.onstage.constants.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka 监听器
 */
@Component
@Slf4j
public class BlogKafkaListener {

    @KafkaListener(topics = KafkaConstants.EMAIL,containerFactory = "kafkaListenerContainerFactory",id = "blog")
    public void processMsg(ConsumerRecord<?,?> msg ){
        log.info("监听器监听到消息,offset:{},partition:{},key:{},value{}",
                msg.offset(),msg.partition(),msg.key(),msg.value());

    }
}
