package com.lee.onstage.controller;


import com.lee.onstage.entity.Output;

import com.lee.onstage.service.OutPutService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/output")
@CrossOrigin(origins = "*")
public class OutPutController {
    @Resource
    private OutPutService outPutService;
    @GetMapping("/1")
    @CrossOrigin("*")
    public Output getRandomOutPut(){
        return outPutService.getRandomOutPut();
    }
}
