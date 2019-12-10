package com.zeng.web.blog.domain.vo;

import com.zeng.web.blog.entity.Comment;
import com.zeng.web.blog.entity.User;
import lombok.Data;

/**
 * @author Zeng
 * @ClassName CommentVo
 * @Description 文章评论视图类
 * @Version 1.0
 **/
@Data
public class CommentVo {
    private User author;
    private Comment comment;
}
