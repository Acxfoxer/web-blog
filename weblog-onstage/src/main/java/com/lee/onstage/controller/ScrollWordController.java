package com.lee.onstage.controller;


import com.lee.onstage.entity.ScrollWorld;

import com.lee.onstage.model.dto.ScrollWordDto;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.ScrollWordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/scrollWord")
@CrossOrigin(origins = "*")
public class ScrollWordController {
    @Resource
    private ScrollWordService scrollWordService;
    @GetMapping("/getDictum")
    @CrossOrigin("*")
    public ResponseResult<?> getRandomOutPut(){
        return scrollWordService.getRandomOutPut();
    }

    @PostMapping("/addDictum")
    @CrossOrigin("*")
    public ResponseResult<?> addDictum(@RequestBody ScrollWordDto scrollWordDto){
        return scrollWordService.addDictum(scrollWordDto);
    }
}
