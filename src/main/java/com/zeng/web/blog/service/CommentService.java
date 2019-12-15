package com.zeng.web.blog.service;

import com.zeng.web.blog.entity.Comment;
import com.zeng.web.blog.util.Result;

/**
 * @author ZENG
 */
public interface CommentService {
    /**
     * 写评论
     * @param comment
     * @return
     */
    Result writeComment(Comment comment);

    /**
     * 查看文章所有评论
     * @param articleId
     * @return
     */
    Result showComment(long articleId);

    /**
     * 删除评论
     * @param userId
     * @param articleId
     * @return
     */
    Result deleteComment(long id);
}
