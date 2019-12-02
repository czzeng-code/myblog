package com.zeng.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Zeng
 * @ClassName Topic
 * @Description TOOD
 * @Date 2019/11/29
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private Long id;
    private Long adminId;
    private String topicName;
    private String logo;
    private String description;
    private String homepage;
    private Integer articles;
    private Integer follows;
    private LocalDateTime createTime;
}
