package com.lee.onstage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置依赖
 * @author lei
 */
@Configuration
public class Knife4jConfiguration{
    @Bean(value = "ApiInfo")
    public Docket ApiInfo() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("个人博客前台API文档")
                        .termsOfServiceUrl("www.spring.io")
                        .contact(new Contact("Acefoxer","https://github.com/Acxfoxer","1872762974@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("1.0")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.lee.onstage.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
