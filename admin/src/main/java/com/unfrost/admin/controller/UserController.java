package com.unfrost.admin.controller;

import com.unfrost.admin.domain.AddUserVO;
import com.unfrost.admin.domain.UpdateUserVO;
import com.unfrost.admin.domain.User;
import com.unfrost.admin.dto.UserInfoDTO;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.admin.repo.UserRepo;
import com.unfrost.admin.service.UserService;
import com.unfrost.admin.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

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
    private final UserService userService;

    @ApiOperation("获取当前登录的用户信息")
    @GetMapping("/current")
    public User current() {
        return UserUtils.gainUserThrow();
    }

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public User add(@RequestBody AddUserVO addUserVO, @RequestParam RoleEnum role) {
        return userService.addUser(addUserVO, role);
    }

    @ApiOperation("更改用户信息")
    @PutMapping("/update")
    public User update(@RequestBody UpdateUserVO updateUserVO, @RequestParam RoleEnum role) {
        return userService.updateUser(updateUserVO, role);
    }

    @ApiOperation("删除用户")
    @PutMapping("/del")
    public void del(@RequestParam String id) {
        userService.delUser(id);
    }

    @ApiOperation("查询所有用户-列表")
    @GetMapping
    public List<User> list() {
        return userRepo.findAllRunning();
    }

    @ApiOperation("查询单个用户")
    @GetMapping("/person")
    public User find(@RequestParam String id) {
        return userRepo.findByIdThrow(id);
    }

    @ApiOperation(value = "用户信息展示", notes = "for-front")
    @GetMapping("/front/person")
    public List<UserInfoDTO> find() {
        return userRepo.findUserInfo();
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
