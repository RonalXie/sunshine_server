package com.ronalxie.service;

import com.ronalxie.model.user.dto.UserLoginDto;

public interface UserService {
    String login(UserLoginDto userLoginDto);
}
