package com.zeng.web.blog.dao.impl;

import com.zeng.web.blog.dao.ArticleDao;
import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @ClassName ArticleDaoImpl
 * @Description TOOD
 * @Date 2019/11/10
 * @Version 1.0
 **/
public class ArticleDaoImpl implements ArticleDao {
    private static Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

    @Override
    public int[] batchInsert(List<Article> articleList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_article (title,content,cover,nickname,comments,likes,create_time) VALUES (?,?,?,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        articleList.forEach(article -> {
            try {
                pstmt.setString(1, article.getTitle());
                pstmt.setString(2, article.getContent());
                pstmt.setString(3, article.getCover());
                pstmt.setString(4, article.getNickname());
                pstmt.setLong(5, article.getComments());
                pstmt.setLong(6, article.getLikes());
                pstmt.setObject(7, article.getCreateTime());
                pstmt.addBatch();
            } catch (SQLException e) {
                logger.error("批量新增出错");
            }

        });
        int[] result = pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null, pstmt, connection);
        return result;

    }

    @Override
    public List<Article> selectHotArticles() throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT id, title, content, cover, nickname, comments, likes, create_time FROM `t_article` ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Article> articleList = new ArrayList<>(60);

        try {
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getLong("id"));
                article.setTitle(rs.getString("title"));
                article.setCover(rs.getString("cover"));
                article.setNickname(rs.getString("nickname"));
                article.setComments(rs.getLong("comments"));
                article.setLikes(rs.getLong("likes"));
                article.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                articleList.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询文章出现异常");
        }
        return articleList;
    }
}
