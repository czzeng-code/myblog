package com.zeng.web.blog.service.impl;

import com.zeng.web.blog.dao.ArticleDao;
import com.zeng.web.blog.dao.UserDao;
import com.zeng.web.blog.domain.dto.UserDto;
import com.zeng.web.blog.domain.vo.ArticleVo;
import com.zeng.web.blog.domain.vo.UserVo;
import com.zeng.web.blog.entity.User;
import com.zeng.web.blog.factory.DaoFactory;
import com.zeng.web.blog.service.UserService;
import com.zeng.web.blog.util.Result;
import com.zeng.web.blog.util.ResultCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Result signIn(UserDto userDto) {
        User user = null;
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if (user != null) {
            //数据库查到的用户密码和前端传递的用户密码（经过加密）相等
            if (user.getPassword().equals(DigestUtils.md5Hex(userDto.getPassword()))) {
                //登录成功
                return Result.success(user);
            } else {
                //密码错误
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            //账号错误
            return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
        }
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

    @Override
    public Result getHotUsers() {
        List<User> userList = null;
        try {
            userList = userDao.selectHotUsers();
        } catch (SQLException e) {
            logger.error("获取热门用户出现异常");
        }
        if (userList != null) {
            //成功并返回数据
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result selectByPage(int currentPage, int count) {
        List<User> userList = null;
        try {
            userList = userDao.selectByPage(currentPage, count);
        } catch (
                SQLException e) {
            logger.error("分页查询用户出现异常");
        }
        if (userList != null) {
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result getUser(long id) {
        UserVo userVo = null;
        try {
            userVo = userDao.getUser(id);
        } catch (SQLException e) {
            logger.error("根据id获取用户详情出现异常");
        }
        if (userVo != null) {
            try {
                List<ArticleVo> articleVoList = articleDao.selectByUserId(id);
                userVo.setArticleList(articleVoList);
                return Result.success(userVo);
            } catch (SQLException e) {
                logger.error("根据用户id获取文章列表数据出现异常");
            }
        }

        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result selectByKeywords(String keywords) {
        List<User> userList = null;
        try {
            userList = userDao.selectByKeywords(keywords);
        } catch (SQLException e) {
            logger.error("根据关键字查询用户出现异常");
        }
        if (userList != null) {
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result alterUser(User user) {
        boolean b = false;
        try {
            b = userDao.alterUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (b) {
            return Result.success();
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);
    }

}
