package com.lee.onstage.controller;


import com.lee.onstage.entity.Output;

import com.lee.onstage.model.dto.OutPutDto;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.OutPutService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/output")
@CrossOrigin(origins = "*")
public class OutPutController {
    @Resource
    private OutPutService outPutService;
    @GetMapping("/getDictum")
    @CrossOrigin("*")
    public Output getRandomOutPut(){
        return outPutService.getRandomOutPut();
    }

    @PostMapping("/addDictum")
    @CrossOrigin("*")
    public ResponseResult<?> addDictum(@RequestBody OutPutDto outPutDto){
        return outPutService.addDictum(outPutDto);
    }
}
