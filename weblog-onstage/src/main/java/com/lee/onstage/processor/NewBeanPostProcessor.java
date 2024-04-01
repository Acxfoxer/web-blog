package com.lee.onstage.processor;

import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 对多线程用TtlExecutors进行装饰
 */
@Configuration
@Slf4j
public class NewBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Executors){
            Executor executor = (Executor) bean;
            if(TtlExecutors.isTtlWrapper(executor)){
                log.info("Executor[{}] is already wrapped by TTLExecutors",executor);
                return executor;
            }
            log.info("Executor[{}] will be wrapped by TTLExecutors",executor);
            return TtlExecutors.getTtlExecutor(executor);
        }
        return bean;
    }
}
