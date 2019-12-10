package com.zeng.web.blog.dao;

import com.zeng.web.blog.entity.Comment;
import com.zeng.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CommentDaoTest {

    private CommentDao commentDao = DaoFactory.getCommentDaoInstance();
    @Test
    public void insert() {
        int n = 0;
        Comment comment = new Comment();
        comment.setUserId(23);
        comment.setArticleId(61);
        comment.setContent("此处省略一篇文章的内容");
        comment.setCreateTime(LocalDateTime.now());
        try {
            n = commentDao.insert(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }
}