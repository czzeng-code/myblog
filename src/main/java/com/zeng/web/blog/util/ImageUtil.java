package com.zeng.web.blog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Filter;

/**
 * @author Zeng
 * @ClassName ImageUtil
 * @Description 图像工具类
 * @Date 2019/11/20
 * @Version 1.0
 **/
public class ImageUtil {
    /**
     * 将字符串绘制成指定大小的图片
     * @param content
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage getImage(int width, int height, String content) {
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        //底色
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 200, 100);
        g.setPaint(new Color(44, 245, 90));
        Font font = new Font("微软雅黑", Font.BOLD, 45);
        g.setFont(font);
        g.drawString(content, width / 4, height/2 );
        g.rotate(1.5);
        return image;
    }
}
