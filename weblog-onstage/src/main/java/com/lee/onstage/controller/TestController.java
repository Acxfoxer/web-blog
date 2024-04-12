package com.lee.onstage.controller;

import com.alibaba.excel.EasyExcel;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lee.onstage.entity.BillInfo;
import com.lee.onstage.ip2region.Ip;
import com.lee.onstage.listener.BillInfoDataListener;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "测试控制层")
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @ApiOperationSupport(author = "up_lyp@163.com")
    @ApiOperation(value = "测试ip2region")
    @GetMapping("/myTest")
    @Ip
    public void myTest(){

    }
    @GetMapping("/testLog")
    public String testLog(HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        log.warn("测试logstash日志");
        return "好";
    }

    @PostMapping("/test123")
    public String test123(@RequestBody String str,HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        return str;
    }
    @GetMapping("/getExcel")
    public String getExcel(){
        String fileName="C:\\Users\\HUAWEI\\Desktop\\应付单.xlsx";
        EasyExcel.read(fileName, BillInfo.class,new BillInfoDataListener()).sheet().doRead();
        return "123";
    }
}
