package com.zeng.web.blog.dao;

import com.zeng.web.blog.entity.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZENG
 */
public interface ArticleDao {
    /**
     * 批量新增文章
     * @param articleList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Article> articleList) throws SQLException;

    /**
     * 查询热门文章，返回视图集合
     * @return
     * @throws SQLException
     */
    List<Article> selectHotArticles() throws SQLException;
}
