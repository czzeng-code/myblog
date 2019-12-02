package com.zeng.web.blog.util;

import com.zeng.web.blog.domain.vo.ArticleVo;
import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.entity.Topic;
import com.zeng.web.blog.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @ClassName BeanHandler
 * @Description 结果集和实体类的转换工具
 * @Date 2019/11/26
 * @Version 1.0
 **/
public class BeanHandler {
    private static Logger logger = LoggerFactory.getLogger(BeanHandler.class);

    public static List<User> convertUser(ResultSet rs) {
        List<User> userList = new ArrayList<>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setAvatar(rs.getString("avatar"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday").toLocalDate());
                user.setIntroduction(rs.getString("introduction"));
                user.setHomepage(rs.getString("homepage"));
                user.setAddress(rs.getString("address"));
                user.setFollows(rs.getShort("follows"));
                user.setFans(rs.getShort("fans"));
                user.setArticles(rs.getShort("articles"));
                user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                user.setStatus(rs.getShort("status"));
                userList.add(user);
            }
        } catch (SQLException e) {
            logger.error("用户数据结果集解析产生异常");
        }
        return userList;
    }

    public static List<ArticleVo> convertArticle(ResultSet rs) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        try {
            while (rs.next()) {
                ArticleVo articleVo = new ArticleVo();
                //文章自身信息
                Article article = new Article();
                article.setId(rs.getLong("id"));
                article.setUserId(rs.getLong("user_id"));
                article.setTopicId(rs.getLong("topic_id"));
                article.setTitle(rs.getString("title"));
                article.setSummary(rs.getString("summary"));
                article.setCover(rs.getString("cover"));
                article.setLikes(rs.getLong("likes"));
                article.setComments(rs.getLong("comments"));
                article.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());

                //作者信息
                User author = new User();
                author.setId(rs.getLong("user_id"));
                author.setNickname(rs.getString("nickname"));
                author.setAvatar(rs.getString("avatar"));

                //专题信息
                Topic topic = new Topic    ();
                topic.setId(rs.getLong("topic_id"));
                topic.setTopicName(rs.getString("topic_name"));
                topic.setLogo(rs.getString("logo"));

                //给文章视图对象设置三块内容
                articleVo.setArticle(article);
                articleVo.setAuthor(author);
                articleVo.setTopic(topic);
                //加入列表
                articleVoList.add(articleVo);
            }
        } catch (SQLException e) {
            logger.error("文章数据结果集解析异常");
            e.printStackTrace();
        }
        return articleVoList;
    }

    public static List<Topic> convertTopic(ResultSet rs) {
        List<Topic> topicList = new ArrayList<>();
        try {
            while (rs.next()) {
                Topic topic = new Topic();
                topic.setId(rs.getLong("id"));
                topic.setAdminId(rs.getLong("admin_id"));
                topic.setTopicName(rs.getString("topic_name"));
                topic.setLogo(rs.getString("logo"));
                topic.setDescription(rs.getString("description"));
                topic.setHomepage(rs.getString("homepage"));
                topic.setArticles(rs.getInt("articles"));
                topic.setFollows(rs.getInt("follows"));
                topic.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                topicList.add(topic);
            }
        } catch (SQLException e) {
            logger.error("专题数据结果集解析产生异常");
        }
        return topicList;
    }
}
