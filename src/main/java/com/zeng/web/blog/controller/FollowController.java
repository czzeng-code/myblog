package com.zeng.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zeng.web.blog.entity.UserFollow;
import com.zeng.web.blog.factory.ServiceFactory;
import com.zeng.web.blog.service.UserFollowService;
import com.zeng.web.blog.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zeng
 * @ClassName FollowController
 * @Description TOOD
 * @Date 2019/12/17
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/follow")
public class FollowController extends HttpServlet {
    UserFollowService userFollowService = ServiceFactory.getUserFollowServiceInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        String fromId = req.getParameter("fromId");
        String toId = req.getParameter("toId");
        Result result = userFollowService.showFollow(Long.valueOf(fromId), Long.valueOf(toId));
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        Gson gson = new GsonBuilder().create();
        UserFollow userFollow = gson.fromJson(stringBuilder.toString(), UserFollow.class);
        Result result = userFollowService.follow(userFollow);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        String fromId = req.getParameter("fromId");
        String toId = req.getParameter("toId");
        Result result = userFollowService.cancelFollow(Long.valueOf(fromId), Long.valueOf(toId));
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }
}
