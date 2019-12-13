package com.zeng.web.blog.dao;

import com.zeng.web.blog.entity.Like;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 * @ClassName LikeDao
 * @Description TOOD
 * @Date 2019/12/11
 * @Version 1.0
 **/
public interface LikeDao {

    /**
     * 查询用户是否喜欢该文章
     * @param useId
     * @param articleId
     * @return
     */
    boolean selectIfLikes(long useId, long articleId) throws SQLException;

    /**
     * 写入一条喜欢
     * @param like
     * @return
     * @throws SQLException
     */
    boolean insertLike(Like like) throws SQLException;

    /**
     * 查询文章喜欢数
     * @param articleId
     * @return
     * @throws SQLException
     */
    long selectLikes(long articleId) throws SQLException;

    /**
     * 点赞文章（文章喜欢数加一）
     * @param articleId
     * @return
     * @throws SQLException
     */
    boolean alterLikes(long articleId) throws SQLException;

    /**
     * 删除一条喜欢
     * @param useId
     * @param articleId
     * @return
     * @throws SQLException
     */
    boolean deleteLike(long useId, long articleId) throws  SQLException;

    /**
     * 取消点赞(赞数减一）
     * @param articleId
     * @return
     * @throws SQLException
     */
    boolean cancelLike(long articleId) throws SQLException;


}
