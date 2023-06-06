package com.ronalxie.service.impl;

import com.ronalxie.mapper.UserMapper;
import com.ronalxie.model.user.UserEntity;
import com.ronalxie.model.user.dto.UserLoginDto;
import com.ronalxie.service.UserService;
import com.ronalxie.util.BeanCopyUtils;
import com.ronalxie.util.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String login(UserLoginDto userLoginDto) {

        UserEntity userEntity = BeanCopyUtils.copyBean(userLoginDto, UserEntity.class);
        userEntity=userMapper.searchUser(userEntity);
        if (ObjectUtils.isEmpty(userEntity)){
            return null;
        }
        String token = JwtUtils.generateToken(userEntity.getId().toString());
        return token;

    }
}
