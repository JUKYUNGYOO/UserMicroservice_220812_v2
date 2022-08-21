package com.example.usermicroservice_220812_v2.service;


import com.example.usermicroservice_220812_v2.dto.UserDto;
import com.example.usermicroservice_220812_v2.jpa.UserEntity;
import com.example.usermicroservice_220812_v2.jpa.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

//UserService 인터페이스를 상속받아 수행할 UserServiceImpl.java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        // UserDto -> UserEntity 변환
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd("encrypted_password"); // 이후에 암호화할 예정
        userRepository.save(userEntity);

        return null;
    }
}
