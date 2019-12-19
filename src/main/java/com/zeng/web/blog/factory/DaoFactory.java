package com.zeng.web.blog.factory;

import com.zeng.web.blog.dao.*;
import com.zeng.web.blog.dao.impl.*;
import com.zeng.web.blog.entity.UserFollow;

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

    public static LikeDao getLikeDaoInstance() {
        return new LikeDaoImpl();
    }

    public static UserFollowDao getUserFollowDaoInstance() {
        return new UserFollowDaoImpl();
    }

}
