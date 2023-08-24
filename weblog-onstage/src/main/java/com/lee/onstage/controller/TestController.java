package com.lee.onstage.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lee.onstage.ip2region.Ip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试控制层")
@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperationSupport(author = "up_lyp@163.com")
    @ApiOperation(value = "测试ip2region")
    @GetMapping("/myTest")
    @Ip
    public void myTest(){
        int i = 1;
        System.out.println("myTest");
    }
}
