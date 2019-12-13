package com.zeng.web.blog.dao;

import com.zeng.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LikeDaoTest {
    private  LikeDao likeDao = DaoFactory.getLikeDaoInstance();

    @Test
    public void selectIfLikes() {

        boolean a= false;
        try {
            a = likeDao.selectIfLikes(16, 4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(a);

    }

    @Test
    public void addOne() {
        try {
            likeDao.alterLikes(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}