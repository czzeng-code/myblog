package com.zeng.web.blog.entity;

import lombok.Data;

/**
 * @author Zeng
 * @ClassName Like
 * @Description TOOD
 * @Date 2019/12/11
 * @Version 1.0
 **/
@Data
public class Like {
    private long id;
    private long userId;
    private long articleId;
}
