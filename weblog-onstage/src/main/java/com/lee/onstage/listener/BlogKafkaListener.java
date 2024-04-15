package com.lee.onstage.listener;

import com.lee.onstage.constants.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * kafka 监听器
 */
@Component
@Slf4j
public class BlogKafkaListener {
    @Resource
    KafkaTemplate<String,Object> kafkaTemplate;

    /**
     * email主题消费者,注意设置的ackMode为MANUAL_IMMEDIATE是需引入Acknowledgment参数,调用acknowledge()手动提交偏移量
     * @param msg
     * @param acknowledgment
     */
    @KafkaListener(topics = KafkaConstants.EMAIL,containerFactory = "kafkaListenerContainerFactory",id = "blog")
    public void processMsg(ConsumerRecord<?,?> msg, Acknowledgment acknowledgment){
        log.info("监听器监听到消息,offset:{},partition:{},key:{},value{}",
                msg.offset(),msg.partition(),msg.key(),msg.value());
        acknowledgment.acknowledge();
    }
}
