package com.lee.onstage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.onstage.annotation.VisitLogger;
import com.lee.onstage.constants.ResultCode;
import com.lee.onstage.entity.Talk;
import com.lee.onstage.entity.Task;
import com.lee.onstage.mapper.TalkMapper;
import com.lee.onstage.model.dto.PageParamDto;
import com.lee.onstage.model.vo.PageResult;
import com.lee.onstage.model.vo.TalkBackInfoVO;
import com.lee.onstage.model.vo.TalkVO;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.TalkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("talk")
public class TalkController {
    final TalkService talkService;

    public TalkController(TalkService talkService) {
        this.talkService = talkService;
    }

    @ApiOperation(value = "查看首页说说")
    @GetMapping("/home")
    public ResponseResult<List<String>> getHomeTalk(){
        List<String> talkContent = talkService.list().stream().map(Talk::getTalkContent).collect(Collectors.toList());
        return ResponseResult.success(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(), talkContent);
    }
    @ApiOperation(value = "查看说说列表")
    @GetMapping("/list")
    @VisitLogger(value = "说说列表")
    public ResponseResult<PageResult<TalkVO>> listTalkVo(PageParamDto pageParamDto){
        return ResponseResult.success(talkService.listTalkVO(pageParamDto));
    }
    @ApiOperation("查看说说内容明细")
    @VisitLogger("查看说说内容明细")
    @GetMapping("/{id}")
    public ResponseResult<TalkVO> listTalkVOById(@PathVariable("id")String id){
        return ResponseResult.success(talkService.listTalkVOById(id));
    }
}
