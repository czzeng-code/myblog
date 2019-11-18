package com.zeng.web.blog.controller;

import cn.hutool.db.Entity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zeng.web.blog.domain.UserDto;
import com.zeng.web.blog.factory.DaoFactory;
import com.zeng.web.blog.factory.ServiceFactory;
import com.zeng.web.blog.service.UserService;
import com.zeng.web.blog.util.Message;
import com.zeng.web.blog.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author Zeng
 * @ClassName UserController
 * @Description 用户控制器
 * @Date 2019/11/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/user/*")
public class UserController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();

    /**
     * 根据请求地址，取得最后的内容，结合请求方法来决定分发到不同的方法
     *
     * @param uri
     * @return
     */
    private String getPatten(String uri) {
        int len = "/api/user".length();
        return uri.substring(len);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对不同的部分进行分发
        String patten = getPatten(req.getRequestURI());
        switch (patten) {
            case "/sign-in":
                signIn(req, resp);
                break;
            case "/sign-up":
                signUp(req, resp);
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Entity> entityList = null;
//        entityList = DaoFactory.getUserDaoInstance().
    }

    /**
     * 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        logger.info("登录用户信息：" + stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        Map<String, Object> map = userService.signIn(userDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        if (msg.equals(Message.SIGN_IN_SUCCESS)) {
            ro = ResponseObject.success(200, msg, map.get("data"));
        } else {
            ro = ResponseObject.success(200, msg);
        }
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }


    private void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        logger.info("sign-up:" + stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        Map<String, Object> map = userService.signUp(userDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        if (msg.equals("注册成功")) {
            ro = ResponseObject.success(200, msg);
        } else {
            ro = ResponseObject.success(200, msg);
        }
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

        @Override
    public void init() throws ServletException {
        logger.info("UserController初始化");
    }
}

