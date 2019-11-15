package com.zeng.web.blog.dao;

import com.zeng.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 * @ClassName UserDao
 * @Description UserDao数据访问对象接口
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 新增用户
     * @param user
     * @return
     * @throws SQLException
     */
    int insert(User user) throws SQLException;
    /**
     * 批量新增用户
     * @param userList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<User> userList) throws SQLException;

    /**
     * 根据手机号查找用户
     * @param mobile
     * @return
     */
    User findUserByMobile(String mobile) throws SQLException;
}
