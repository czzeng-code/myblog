package com.zeng.web.blog.domain.vo;

import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.entity.Topic;
import com.zeng.web.blog.entity.User;
import lombok.Data;

/**
 * @author Zeng
 * @ClassName ArticleVo
 * @Description 文章视图类, 从文章、专题、用户表联查出前端需要展示的数据
 * @Date 2019/11/29
 * @Version 1.0
 **/
@Data
public class ArticleVo {
    private Article article;
    private User author;
    private Topic topic;
}
