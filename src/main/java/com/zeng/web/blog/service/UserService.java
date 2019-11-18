package com.zeng.web.blog.service;

import com.zeng.web.blog.domain.UserDto;

import java.util.Map;

public interface UserService {
    /**
     * 用户登录功能
     * @param userDto
     * @return
     */
    Map<String, Object> signIn(UserDto userDto);

    /**
     * 用户注册功能
     * @param userDto
     * @return
     */
    Map<String, Object> signUp(UserDto userDto);
}
