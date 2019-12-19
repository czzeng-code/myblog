package com.zeng.web.blog.dao;

import com.zeng.web.blog.entity.UserFollow;

import java.sql.SQLException;

/**
 * @author Zeng
 * @ClassName UserFollowDao
 * @Description TOOD
 * @Date 2019/12/17
 * @Version 1.0
 **/
public interface UserFollowDao {
    /**
     * 查询关注
     * @param fromId
     * @param toId
     * @return
     * @throws SQLException
     */
    boolean selectFollow(long fromId, long toId) throws SQLException;

    /**
     * 插入一条关注信息
     * @param userFollow
     * @return
     * @throws SQLException
     */
    boolean insertFollow(UserFollow userFollow) throws SQLException;

    /**
     * 删除关注
     * @param fromId
     * @param toId
     * @return
     * @throws SQLException
     */
    boolean deleeteFollow(long fromId, long toId) throws SQLException;
}
