package com.zeng.web.blog.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zeng
 * @ClassName UserDTO
 * @Description TOOD
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
public class UserDto implements Serializable {
    private String mobile;
    private String password;
    private String code;
}
