package com.zeng.web.blog.dao.impl;

import com.zeng.web.blog.dao.ArticleDao;
import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        DbUtil.close(null,pstmt,connection);
        return result;

    }
}
