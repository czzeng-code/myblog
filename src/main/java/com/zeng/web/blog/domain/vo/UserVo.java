package com.zeng.web.blog.domain.vo;

import com.zeng.web.blog.entity.Article;
import com.zeng.web.blog.entity.Topic;
import com.zeng.web.blog.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author Zeng
 * @ClassName UserVo
 * @Description 用户视图类
 * @Date 2019/11/22
 * @Version 1.0
 **/
@Data
public class UserVo {
    private User user;
    private List<Article> articles;
    private List<ArticleVo> articleList;
    private List<Topic> topicList;
    private List<User> fansList;
}
