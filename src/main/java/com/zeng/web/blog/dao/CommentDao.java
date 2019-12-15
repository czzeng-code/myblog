package com.zeng.web.blog.dao;

import com.zeng.web.blog.domain.vo.CommentVo;
import com.zeng.web.blog.entity.Comment;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 * @ClassName CommentDao
 * @Description 评论dao
 * @Date 2019/12/9
 * @Version 1.0
 **/
public interface CommentDao {
    /**
     * 新增评论
     * @param comment
     * @return
     * @throws SQLException
     */
    int insert(Comment comment) throws SQLException;

    /**
     * 根据文章id查出所有评论
     * @param articleId
     * @return
     * @throws SQLException
     */
    List<CommentVo> getCommments(long articleId) throws SQLException;

    /**
     * 删除评论
     * @param id
     * @return
     * @throws SQLException
     */
    boolean deleteComment(long id) throws SQLException;

}
