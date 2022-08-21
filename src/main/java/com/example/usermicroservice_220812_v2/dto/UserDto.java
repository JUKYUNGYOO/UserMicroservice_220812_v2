package com.example.usermicroservice_220812_v2.dto;


import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createAt;

    private String encryptedPwd;
}
