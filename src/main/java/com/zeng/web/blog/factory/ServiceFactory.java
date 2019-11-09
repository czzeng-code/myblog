package com.zeng.web.blog.factory;

import com.zeng.web.blog.service.UserService;
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
}
