package com.zeng.web.blog.factory;

import com.zeng.web.blog.service.*;
import com.zeng.web.blog.service.impl.*;

/**
 * @author Zeng
 * @ClassName ServiceFactory
 * @Description TOOD
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class ServiceFactory {

    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }

    public static ArticleService getArticleServiceInstance() {
        return new ArticleServiceImpl();
    }

    public static TopicService getTopicServiceInstance() {
        return new TopicServiceImpl();
    }

    public static CommentService getCommentServiceInstance() {
        return new CommentServiceImpl();
    }

    public static LikeService getLikeServiceInstance() {
        return new LikeServiceImpl();
    }

}
