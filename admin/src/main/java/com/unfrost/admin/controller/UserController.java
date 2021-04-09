package com.unfrost.admin.controller;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.repo.UserRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-07 13:54
 */
@Api(tags = "用户控制")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserRepo userRepo;

    @ApiOperation("测试")
    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @ApiOperation("查询所有用户-列表")
    @GetMapping
    public List<User> list() {
        return userRepo.findAll();
    }

    @ApiOperation("登录已过期")
    @GetMapping("/time-out")
    public ResultVO sessionTimeOut() {
        return ResultVO.error();
    }

    @Data
    private static class ResultVO {
        private String message;
        private String code;
        private static ResultVO resultVO = null;

        public static ResultVO error() {
            if (resultVO == null) {
                resultVO = new ResultVO();
                resultVO.setCode("412");
                resultVO.setMessage("登录超时,请重新登录!");
            }
            return resultVO;
        }
    }
}
