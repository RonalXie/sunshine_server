package com.ronalxie.model.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo {


    private String username;


    private String nickname;

    private String intro;

    private String avater;

    private Byte age;

    private Byte sex;

    private String email;

}
