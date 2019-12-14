package com.zeng.web.blog.service;

import com.zeng.web.blog.domain.dto.UserDto;
import com.zeng.web.blog.entity.User;
import com.zeng.web.blog.util.Result;

import java.util.Map;

/**
 * @author ZENG
 */
public interface UserService {
    /**
     * 用户登录功能
     * @param userDto
     * @return
     */
    Result signIn(UserDto userDto);

    /**
     * 用户注册功能
     * @param userDto
     * @return
     */
    Map<String, Object> signUp(UserDto userDto);

    /**
     * 获取热门用户信息
     * @return
     */
    Result getHotUsers();

    /**
     * 获取分页用户信息
     * @param currentPage
     * @param count
     * @return
     */
    Result selectByPage(int currentPage,int count);

    /**
     * 根据id查询用户详情数据
     * @param id
     * @return
     */
    Result getUser(long id);

    /**
     * 根据昵称或简介模糊搜索用户
     *
     * @param keywords
     * @return
     */
    Result selectByKeywords(String keywords);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    Result alterUser(User user);
}
