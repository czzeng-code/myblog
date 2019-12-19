package com.zeng.web.blog.entity;

import lombok.Data;

/**
 * @author Zeng
 * @ClassName UserFollow
 * @Description 用户关注实体类
 * @Date 2019/12/17
 * @Version 1.0
 **/
@Data
public class UserFollow {
    private long id;
    private long fromId;
    private long toId;
}
