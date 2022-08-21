package com.example.usermicroservice_220812_v2.jpa;


//UserEntity와 DB를 다룰 UserRepository.java 인터페이스를 만들겠습니다.

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
