package com.unfrost.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-07 13:54
 */
@Api(tags = "用户控制")
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation("测试")
    @GetMapping("/test")
    public String test() {
        return "hello world";
    }
}
