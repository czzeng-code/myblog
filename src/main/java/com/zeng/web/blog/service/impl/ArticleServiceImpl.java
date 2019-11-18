package com.zeng.web.blog.service.impl;

import com.zeng.web.blog.dao.ArticleDao;
import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.factory.DaoFactory;
import com.zeng.web.blog.service.ArticleService;
import com.zeng.web.blog.util.ResponseObject;
import com.zeng.web.blog.util.Result;
import com.zeng.web.blog.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 * @ClassName ArticleServiceImpl
 * @Description TOOD
 * @Date 2019/11/18
 * @Version 1.0
 **/
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Override
    public Result getHotArticles() {
        List<Article> articleList = null;
        try {
            articleList = articleDao.selectHotArticles();
        } catch (SQLException e) {
            logger.error("查询热门文章出现异常");
        }
        if (articleList != null) {
            return Result.success(articleList);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);

    }
}
