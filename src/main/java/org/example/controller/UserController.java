package org.example.controller;

import jakarta.validation.Valid;
;
import org.example.entity.User;
import org.example.pojo.ApiResponse;
import org.example.pojo.dto.UserLoginDto;
import org.example.pojo.vo.UserVo;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo1")
public class UserController {
    @Autowired
    private UserService userService;

    public ApiResponse<UserVo> login(@Valid @RequestBody UserLoginDto userLoginDto){
        return ApiResponse.ok();
    }
    @GetMapping("/{userId}")
    public ApiResponse<UserVo> getUserById(@PathVariable("userId") Long userId) {
        return ApiResponse.ok(userService.getUserById(userId));
    }
}
