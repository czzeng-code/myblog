package com.zeng.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Zeng
 * @ClassName Student
 * @Description TOOD
 * @Date 2019/11/6
 * @Version 1.0
 **/
@Data
public class Student {
    private Integer id;
    private String username;
    private String avatar;
    private LocalDateTime createTime;
    private String description;

}
