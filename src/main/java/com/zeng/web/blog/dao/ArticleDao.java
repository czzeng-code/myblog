package com.zeng.web.blog.dao;

import com.zeng.web.blog.domain.vo.ArticleVo;
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

    /**
     * 分页获得文章数据
     *
     * @param currentPage
     * @param count
     * @return
     * @throws SQLException
     */
    List<ArticleVo> selectByPage(int currentPage, int count) throws SQLException;


    /**
     * 根据关键字模糊查询所有文章
     *
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<ArticleVo> selectByKeywords(String keywords) throws SQLException;


    /**
     * 根据专题id查询所有文章
     *
     * @param topicId
     * @return
     * @throws SQLException
     */
    List<ArticleVo> selectByTopicId(long topicId) throws SQLException;

    /**
     * 根据作者id查询所有文章
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    List<ArticleVo> selectByUserId(long userId) throws SQLException;

    /**
     * 根据id获取文章详情
     *
     * @param id
     * @return
     * @throws SQLException
     */
    ArticleVo getArticle(long id) throws SQLException;

    /**
     * 插入一条文章
     * @param article
     * @return
     * @throws SQLException
     */
    boolean insert(Article article) throws SQLException;
}
