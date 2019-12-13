package com.zeng.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zeng.web.blog.entity.Comment;
import com.zeng.web.blog.entity.Like;
import com.zeng.web.blog.factory.ServiceFactory;
import com.zeng.web.blog.service.CommentService;
import com.zeng.web.blog.service.LikeService;
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
 * @ClassName LikeController
 * @Description TOOD
 * @Date 2019/12/11
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/like")
public class LikeController extends HttpServlet {

    private LikeService  likeService = ServiceFactory.getLikeServiceInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        String userId = req.getParameter("userId");
        String articleId = req.getParameter("articleId");
        Result result = likeService.getLike(Long.valueOf(userId), Long.valueOf(articleId));
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line ;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        Gson gson = new GsonBuilder().create();
        Like like = gson.fromJson(stringBuilder.toString(), Like.class);
        Result result = likeService.addLike(like);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        String userId = req.getParameter("userId");
        String articleId = req.getParameter("articleId");
        Result result = likeService.lessenLike(Long.valueOf(userId), Long.valueOf(articleId));
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }
}
