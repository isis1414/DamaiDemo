package org.example.controller;

import jakarta.validation.Valid;
import org.example.pojo.ApiResponse;
import org.example.pojo.dto.UserLoginDto;
import org.example.pojo.vo.UserLoginVo;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    public ApiResponse<UserLoginVo> login(@Valid @RequestBody UserLoginDto userLoginDto){
        return ApiResponse.ok();
    }
}
