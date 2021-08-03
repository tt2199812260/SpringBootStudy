package com.mingdev.controller;

import com.mingdev.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class HelloController {

    @GetMapping( "/hello" )
    public String hello(){
        return "Hello world";
    }

    //只要我们的接口中，返回值中存在实体类，就会被扫描到swagger中
    @ApiOperation("用户接口")
    @PostMapping( "/user" )
    public User user(){
        return new User();
    }

    @PostMapping( "/hi" )
    public String hi(@ApiParam("用户名")  String username){
        return "hi,"+username;
    }

    @ApiOperation("Test测试")
    @PostMapping( "/test" )
    public User test(@ApiParam("用户名")  User user){
        return user;
    }
}
