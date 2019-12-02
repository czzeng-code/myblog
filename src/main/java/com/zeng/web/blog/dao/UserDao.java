package com.zeng.web.blog.dao;

import com.zeng.web.blog.domain.dto.UserDto;
import com.zeng.web.blog.domain.vo.UserVo;
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
     * @param userDto
     * @return
     * @throws SQLException
     */
    int insert(UserDto userDto) throws SQLException;
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

    /**
     * 查询热门用户
     * @return
     * @throws SQLException
     */
    List<User> selectHotUsers() throws  SQLException;

    /**
     * 查询分页用户
     * @param
     * @return
     * @throws SQLException
     */
    List<User> selectByPage(int currentPage, int count) throws SQLException;

    /**
     * 根据id查询用户
     * @param  id
     * @return
     * @throws SQLException
     */
    UserVo getUser(long id) throws SQLException;


    /**
     * 模糊搜索用户
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<User> selectByKeywords(String keywords) throws SQLException;


}
