package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // ioc, 트랜잭션 관리 해줌
public class AuthService {


    private final UserRepository userRepository;
    

    
    public User signup(User user){
        //회원가입 진행
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
