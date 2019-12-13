package com.zeng.web.blog.service;

import com.zeng.web.blog.entity.Like;
import com.zeng.web.blog.util.Result;

/**
 * @author Zeng
 * @ClassName LikeService
 * @Description TOOD
 * @Date 2019/12/11
 * @Version 1.0
 **/
public interface LikeService {

    /**
     * 获得喜欢信息
     * @param userId
     * @param articleId
     * @return
     */
    Result getLike(long userId, long articleId);

    /**
     * 喜欢数加一
     * @param like
     * @return
     */
    Result addLike(Like like);

    /**
     * 取消喜欢
     * @param userId
     * @param articleId
     * @return
     */
    Result lessenLike(long userId, long articleId);
}
