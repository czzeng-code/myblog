package com.zeng.web.blog.util;

import com.zeng.web.blog.entity.Article;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @ClassName JSoupDemo
 * @Description jsoup解析器练习
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class JSoupDemo {
    public static void main(String[] args) throws Exception {
      /*  //声明文档变量
        Document document;
        //通过JSoup连接目标页面
        document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
        //选取所有class为col-xs-8的元素集合·
        Elements divs = document.getElementsByClass("col-xs-8");
        //对divs遍历
        divs.forEach(div-> {
            //取出class为wrap的节点
            Element wrapDiv = div.child(0);
            System.out.println(wrapDiv.html());
            System.out.println(wrapDiv.child(0).child(1).text());
            System.out.println("https:" + wrapDiv.child(0).child(0).attr("src"));
            System.out.println();


        });*/
/*
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        for (int i = 0; i <= 100; i += 20) {
            try {
                document = Jsoup.connect("https://book.douban.com/review/best/?start=" + i).get();

            } catch (IOException e) {
                System.err.println("出错");
            }
            Elements divs = document.getElementsByClass("main review-item");
            divs.forEach(div -> {
                //title
                System.out.println(div.child(2).child(0).text());
                //cover
                System.out.println(div.child(0).child(0).attr("src"));
                //nickname
                System.out.println(div.child(1).child(1).text());
                //content
                System.out.println(div.child(2).child(1).child(0).text());
                //comments
                System.out.println(div.child(2).child(3).child(2).text().substring(0,div.child(2).child(3).child(2).text().length()-2));
                //likes
                System.out.println(div.child(2).child(3).child(0).child(1).text());

            });
        }*/

        Document doc = null;
        doc = Jsoup.connect("https://www.jianshu.com/p/d2afbce8a892").get();
        Elements divs = doc.getElementsByClass("_2rhmJa");
        Element div = divs.get(0);
        System.out.println(div.getElementsByTag("p"));
    }
}
