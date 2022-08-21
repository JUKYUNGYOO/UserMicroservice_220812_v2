package com.example.usermicroservice_220812_v2.service;

import com.example.usermicroservice_220812_v2.dto.UserDto;


//UserDto 객체를 다루기 위해서 UserService.java 인터페이스
public interface UserService {
    UserDto createUser(UserDto userDto);
}
