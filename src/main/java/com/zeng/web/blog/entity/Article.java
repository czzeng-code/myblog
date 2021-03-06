package com.zeng.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Zeng
 * @ClassName Article
 * @Description 文章实体
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
public class Article {
    private Long id;
    private Long userId;
    private Long topicId;
    private String title;
    private String summary;
    private String content;
    private String cover;
    private String nickname;
    private Long comments;
    private Long likes;
    private LocalDateTime createTime;


}
