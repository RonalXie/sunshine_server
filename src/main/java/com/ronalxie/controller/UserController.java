package com.ronalxie.controller;

import com.ronalxie.model.RespBean;
import com.ronalxie.model.user.dto.UserLoginDto;
import com.ronalxie.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public RespBean login(@RequestBody UserLoginDto userLoginDto){

        String token=userService.login(userLoginDto);

        return RespBean.success("验证信息",token);
    }


}
