package com.zeng.web.blog.service;

import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.util.Result;

/**
 * @author Zeng
 * @ClassName ArticleService
 * @Description TOOD
 * @Date 2019/11/18
 * @Version 1.0
 **/
public interface ArticleService {
    /**
     * 获取热门文章
     * @return
     */
    Result getHotArticles();

    /**
     * 获取分页文章
     *
     * @param currentPage
     * @param count
     * @return
     */
    Result getArticlesByPage(int currentPage, int count);

    /**
     * 获取文章详情
     *
     * @param id
     * @return
     */
    Result getArticle(long id);


    /**
     * 根据标题或摘要模糊查询文章
     *
     * @param keywords
     * @return
     */
    Result selectByKeywords(String keywords);

    /**
     * 写文章
     * @param article
     * @return
     */
    Result writeArticle(Article article);
}
