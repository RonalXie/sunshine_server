package com.ronalxie.service.impl;

import com.ronalxie.mapper.UserMapper;
import com.ronalxie.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Mapper
    private UserMapper userMapper;
}
