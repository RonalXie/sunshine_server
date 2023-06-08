package com.ronalxie.service;

import com.ronalxie.model.user.dto.UserLoginDto;
import com.ronalxie.model.user.vo.UserInfoVo;

public interface UserService {
    String login(UserLoginDto userLoginDto);

    UserInfoVo searchUser(Long id);
}
