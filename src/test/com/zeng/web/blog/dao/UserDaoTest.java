package com.zeng.web.blog.dao;

import com.zeng.web.blog.entity.User;
import com.zeng.web.blog.factory.DaoFactory;
import com.zeng.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;


public class UserDaoTest {

    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    @Test
    public void batchInsert() {
        try {
            int[] result = userDao.batchInsert(JSoupSpider.getUsers());
            if (result.length != 0) {
                logger.info("成功新增" + result.length + "个用户");
            }
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }


    @Test
    public void findUserByMobile() {
        User user = null;
        try {
            user = userDao.findUserByMobile("13913267557");
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        System.out.println(user);
    }
}