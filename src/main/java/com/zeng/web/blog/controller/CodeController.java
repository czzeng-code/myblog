package com.zeng.web.blog.controller;

import com.zeng.web.blog.util.ImageUtil;
import com.zeng.web.blog.util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Zeng
 * @ClassName CodeController
 * @Description 验证码请求
 * @Date 2019/11/20
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/code")
public class CodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = StringUtil.getCode();
        BufferedImage image = ImageUtil.getImage(code, 200, 100);
        //设置响应内容类型
        resp.setContentType("image/jpg");
        OutputStream out = resp.getOutputStream();
        ImageIO.write(image,"jpg", out);
        out.close();
    }
}
