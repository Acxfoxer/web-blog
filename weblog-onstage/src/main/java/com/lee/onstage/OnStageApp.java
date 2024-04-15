package com.lee.onstage;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKnife4j
@MapperScan("com.lee.onstage.mapper")
@ComponentScan({"com.lee","springfox.documentation.schema"})
@EnableKafka
public class OnStageApp {
    public static void main(String[] args) {
        SpringApplication.run(OnStageApp.class);
    }
}
