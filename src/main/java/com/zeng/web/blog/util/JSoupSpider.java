package com.zeng.web.blog.util;

import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.entity.Student;
import com.zeng.web.blog.entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @ClassName JSoupSpider
 * @Description JSoup实现的一个爬虫
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpider {

    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);

    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("网页连接出错");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(DataUtil.getMobile());
                user.setPassword(DataUtil.getPassword());
                user.setGender(DataUtil.getGender());
                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setNickname(linkChildren.get(1).text());
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(DataUtil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }

    public static List<Article> getArticles() {
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        for (int i = 0; i <= 100; i+=20) {
            try {
                document = Jsoup.connect("https://book.douban.com/review/best/?start=" + i).get();
            } catch (IOException e) {
                logger.error("网页连接出错");
            }
            Elements divs = document.getElementsByClass("main review-item");
            divs.forEach(div -> {
                Article article = new Article();
                article.setTitle(div.child(2).child(0).text());
                article.setContent(div.child(2).child(1).child(0).text());
                article.setCover(div.child(0).child(0).attr("src"));
                article.setNickname(div.child(1).child(1).text());
                article.setComments(Long.valueOf(div.child(2).child(3).child(2).text().substring(0,div.child(2).child(3).child(2).text().length()-2)));
                article.setLikes(Long.valueOf(div.child(2).child(3).child(0).child(1).text()));
                article.setCreateTime(LocalDateTime.now());
                articleList.add(article);
            });
        }
        return articleList;
    }
}
