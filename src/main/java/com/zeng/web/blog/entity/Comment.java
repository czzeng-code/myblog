package com.zeng.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Zeng
 * @ClassName Comment
 * @Description TOOD
 * @Date 2019/12/9
 * @Version 1.0
 **/
@Data
public class Comment {
    private long id;
    private long userId;
    private long articleId;
    private String content;
    private LocalDateTime createTime;

}
