package com.zeng.web.blog.factory;

import com.zeng.web.blog.service.ArticleService;
import com.zeng.web.blog.service.TopicService;
import com.zeng.web.blog.service.UserService;
import com.zeng.web.blog.service.impl.ArticleServiceImpl;
import com.zeng.web.blog.service.impl.TopicServiceImpl;
import com.zeng.web.blog.service.impl.UserServiceImpl;

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

}
