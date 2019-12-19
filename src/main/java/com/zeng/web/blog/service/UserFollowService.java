package com.zeng.web.blog.service;

import com.zeng.web.blog.entity.UserFollow;
import com.zeng.web.blog.util.Result;

/**
 * @author Zeng
 * @ClassName UserFollowService
 * @Description TOOD
 * @Date 2019/12/17
 * @Version 1.0
 **/
public interface UserFollowService {

    /**
     * 查
     * @param fromId
     * @param toId
     * @return
     */
    Result showFollow(long fromId, long toId) ;

    /**
     * 关注
     * @param userFollow
     * @return
     */
    Result follow(UserFollow userFollow);

    /**
     * 取消关注
     * @param fromId
     * @param toId
     * @return
     */
    Result cancelFollow(long fromId, long toId);
}
