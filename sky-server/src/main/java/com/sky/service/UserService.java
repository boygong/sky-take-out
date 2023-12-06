package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
public interface UserService {

    //微信登录
    User wxLogin(UserLoginDTO userLoginDTO);
}
