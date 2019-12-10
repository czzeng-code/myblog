package com.zeng.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zeng.web.blog.entity.Comment;
import com.zeng.web.blog.factory.ServiceFactory;
import com.zeng.web.blog.service.CommentService;
import com.zeng.web.blog.util.Result;
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

/**
 * @author Zeng
 * @ClassName CommentController
 * @Description 评论控制层
 * @Date 2019/12/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/comment")
public class CommentController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(CommentController.class);
    private CommentService commentService = ServiceFactory.getCommentServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new GsonBuilder().create();
        String id = req.getParameter("articleId");
        Result result = commentService.showComment(Long.valueOf(id));
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
        Comment comment = gson.fromJson(stringBuilder.toString(), Comment.class);
        Result result = commentService.writeComment(comment);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }


}
