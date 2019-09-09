package com.example.swagger.controller;

import com.example.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }


    //只要我们的接口中，返回值中存在实体类，它就会被扫描到Swagger中
    @PostMapping("/user")
    public User user(){
        return new User();

    }

    @GetMapping("/hello2")
    @ApiOperation("Hello控制类")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

}
