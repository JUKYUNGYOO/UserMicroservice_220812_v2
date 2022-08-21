package com.example.usermicroservice_220812_v2.vo;


//저장된 값을 받아서 반환하기 위한 Value Object인 ResponseUser.java

import lombok.Data;

@Data
public class ResponseUser {

    private String email;
    private String name;
    private String UserId;
}
