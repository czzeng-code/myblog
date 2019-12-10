package com.zeng.web.blog.factory;

import com.zeng.web.blog.dao.ArticleDao;
import com.zeng.web.blog.dao.CommentDao;
import com.zeng.web.blog.dao.TopicDao;
import com.zeng.web.blog.dao.UserDao;
import com.zeng.web.blog.dao.impl.ArticleDaoImpl;
import com.zeng.web.blog.dao.impl.CommentDaoImpl;
import com.zeng.web.blog.dao.impl.TopicDaoImpl;
import com.zeng.web.blog.dao.impl.UserDaoImpl;

/**
 * @author Zeng
 * @ClassName DaoFactory
 * @Description TOOD
 * @Date 2019/11/6
 * @Version 1.0
 **/
public class DaoFactory {


    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }

    public static ArticleDao getArticleDaoInstance() {
        return new ArticleDaoImpl();
    }

    public static TopicDao getTopicDaoInstance() {
        return new TopicDaoImpl();
    }

    public  static CommentDao getCommentDaoInstance() {
        return new CommentDaoImpl();
    }
}
