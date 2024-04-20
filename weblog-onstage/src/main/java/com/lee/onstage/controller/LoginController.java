package com.lee.onstage.controller;

import com.lee.onstage.model.dto.UserRegisterDto;
import com.lee.onstage.result.ResponseResult;
import com.lee.onstage.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "登录模块")
@RestController
@CrossOrigin(maxAge = 3600)
public class LoginController {

    @Resource
    LoginService loginService;

    @ApiOperation(value = "发送验证码")
    @GetMapping("/code")
    public ResponseResult<?> sendCode(String email){
        loginService.sendCode(email);
        return ResponseResult.success();
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public ResponseResult<?> register(@RequestBody UserRegisterDto userRegisterDto){
        loginService.register(userRegisterDto);
       return ResponseResult.success();

    }
}
