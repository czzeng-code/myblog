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
    public static BufferedImage getImage(String content, int width, int height) {
        BufferedImage image = new BufferedImage(width,height,1);
        Graphics2D g = (Graphics2D) image.getGraphics();
        //底色
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 200, 100);
        g.setPaint(new Color(62, 63,65));
        Font font = new Font("微软雅黑", Font.BOLD, 35);
        g.setFont(font);
        g.drawString(content,60, 60);
        return image;
    }

    public static void main(String[] args) throws IOException {
        String code = StringUtil.getCode();
        BufferedImage image = ImageUtil.getImage(code, 200, 100);
        File file = new File("D:/code.jpg");
        ImageIO.write(image,"jpg", file);
    }
}
