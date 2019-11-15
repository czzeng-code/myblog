package com.zeng.web.blog.dao;

import com.zeng.web.blog.factory.DaoFactory;
import com.zeng.web.blog.util.JSoupSpider;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ArticleDaoTest {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(ArticleDaoTest.class);
    @Test
    public void batchInsert() {
//        System.out.println(JSoupSpider.getArticles());
        try {
            int[] result = articleDao.batchInsert(JSoupSpider.getArticles());
            if (result.length != 0) {
                logger.info("成功新增" + result.length + "篇文章");
            }
        } catch (SQLException e) {
            logger.error("批量新增文章出现异常");
        }
    }
}