package com.zeng.web.blog.service.impl;

import com.zeng.web.blog.dao.UserDao;
import com.zeng.web.blog.domain.UserDto;
import com.zeng.web.blog.entity.User;
import com.zeng.web.blog.factory.DaoFactory;
import com.zeng.web.blog.service.UserService;
import com.zeng.web.blog.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zeng
 * @ClassName UserServiceImpl
 * @Description 用户业务逻辑接口实现类
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Map<String, Object> signIn(UserDto userDto) {
        User user = null;
        Map<String, Object> map = new HashMap<>();
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if (user != null) {
            if (user.getPassword().equals(userDto.getPassword())){
                map.put("msg", Message.SIGN_IN_SUCCESS);
                map.put("data", user);
            } else {
                map.put("msg", Message.PASSWORD_ERROR);
            }
        } else {
            map.put("msg", Message.MOBILE_NOT_FOUND);
        }
        return map;
    }

    @Override
    public Map<String, Object> signUp(UserDto userDto) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;
        try {
           result = userDao.insert(userDto);
        } catch (SQLException e) {
            logger.error("新增用户异常");
        }
        if (result == 1) {
            map.put("msg", "注册成功");
        } else {
            map.put("msg", "注册失败");
        }

        return map;

    }
}
