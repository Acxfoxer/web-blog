package com.lee.onstage.listener;

import com.lee.onstage.constants.KafkaConstants;
import com.lee.onstage.model.dto.EmailDto;
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
     * email主题消费者,注意设置的ackMode为MANUAL_IMMEDIATE是需引入1Acknowledgment参数,调用acknowledge()手动提交偏移量
     * @param msg            监听到的信息
     * @param acknowledgment 唤醒参数
     */
    @KafkaListener(topics = KafkaConstants.EMAIL,containerFactory = "kafkaListenerContainerFactory",id = "blog",errorHandler = "myTopicErrorHandler" )
        public void processMsg(ConsumerRecord<String, Object> msg, Acknowledgment acknowledgment){
        log.info("监听器监听到消息,offset:{},partition:{},key:{},value{}",
                msg.offset(),msg.partition(),msg.key(),msg.value());
        acknowledgment.acknowledge();
    }
}
