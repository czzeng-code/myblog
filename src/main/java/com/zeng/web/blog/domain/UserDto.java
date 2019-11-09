package com.zeng.web.blog.domain;

import lombok.Data;

/**
 * @author Zeng
 * @ClassName UserDTO
 * @Description TOOD
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
public class UserDto {
    private String mobile;
    private String password;

    public UserDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public UserDto() {
    }
}
