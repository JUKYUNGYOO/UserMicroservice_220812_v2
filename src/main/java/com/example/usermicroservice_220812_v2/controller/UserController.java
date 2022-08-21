package com.example.usermicroservice_220812_v2.controller;


import com.example.usermicroservice_220812_v2.dto.UserDto;
import com.example.usermicroservice_220812_v2.service.UserService;
import com.example.usermicroservice_220812_v2.vo.ResponseUser;
import com.example.usermicroservice_220812_v2.vo.RequestUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// UserController.java에 request를 받아서 DB에 저장하는 코드

@RestController
@RequestMapping("/user-service/")
public class UserController {

    private Environment env;
    private UserService userService;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){

        // RequestUser -> UserDto 변환
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        // userDto -> ResponseUser 변환하여 결과 값으로 반환
        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        // 어떤 정보가 저장되었는지 반환하여 보여줄 수 있다.
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser); // Status : 201, Body : ResponseUser
    }
}
