package com.lee.onstage.controller;

import com.lee.onstage.constants.ResultCode;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.TalkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("talk")
public class TalkController {
    final TalkService talkService;

    public TalkController(TalkService talkService) {
        this.talkService = talkService;
    }

    @GetMapping("/home")
    public ResponseResult getHomeTalk(){
        List<Talk> list = talkService.list();
        return ResponseResult.success(ResultCode.SUCCESS.getValue(),ResultCode.SUCCESS.getMsg(), list);
    }
}
