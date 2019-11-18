package com.zeng.web.blog.service;

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
}
