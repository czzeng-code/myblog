package com.zeng.web.blog.dao.impl;

import com.zeng.web.blog.dao.UserFollowDao;
import com.zeng.web.blog.entity.UserFollow;
import com.zeng.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zeng
 * @ClassName UserFollowDaoImpl
 * @Description TOOD
 * @Date 2019/12/17
 * @Version 1.0
 **/
public class UserFollowDaoImpl implements UserFollowDao {
    @Override
    public boolean selectFollow(long fromId, long toId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user_follow WHERE from_id=? AND to_id=? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, fromId);
        pstmt.setLong(2, toId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insertFollow(UserFollow userFollow) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_user_follow (from_id,to_id) VALUES (?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, userFollow.getFromId());
        pstmt.setLong(2, userFollow.getToId());
        int i = pstmt.executeUpdate();
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleeteFollow(long fromId, long toId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "DELETE FROM t_user_follow WHERE from_id=? AND to_id=? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, fromId);
        pstmt.setLong(2, toId);
        int rs = pstmt.executeUpdate();
        if (rs ==1) {
            return true;
        }
        return false;
    }
}
