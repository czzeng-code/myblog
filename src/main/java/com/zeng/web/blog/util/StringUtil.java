package com.zeng.web.blog.util;

import java.util.Random;

/**
 * @author Zeng
 * @ClassName StringUtil
 * @Description 生成四位验证码
 * @Date 2019/11/20
 * @Version 1.0
 **/
public class StringUtil {

   public static String getCode() {
       StringBuilder stringBuilder = new StringBuilder();
       int digitalBound = 10;
       int charBound = 26;
       char[] chars = new char[digitalBound+charBound*2];
       int index = 0;
       for (int i = 0; i< digitalBound; i++){
           chars[i] = (char) ('0' +index);
           index++;
       }
       index = 0;
       for (int i = digitalBound; i< charBound+digitalBound; i++){
           chars[i] = (char) ('A' +index);
           index++;
       }
       index = 0;
       for (int i = digitalBound+charBound; i< charBound*2+digitalBound; i++){
           chars[i] = (char) ('a' +index);
           index++;
       }

       Random random = new Random();
       for (int i = 0; i< 4; i++) {
           int num = random.nextInt(62);
           stringBuilder.append(chars[num]);
       }
       return stringBuilder.toString();
   }

    public static void main(String[] args) {
        while (true) {
            System.out.println("验证码：" + StringUtil.getCode());
        }


    }
}
