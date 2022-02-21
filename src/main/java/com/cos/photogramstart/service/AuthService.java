package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // ioc, 트랜잭션 관리 해줌
public class AuthService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @Transactional // write (insert,update,delete 시)
    public User signup(User user){
        //회원가입 진행
        //패스워드 암호화 진행
        String rawPassword=user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("ROLE_USER"); // 관리자는 ROLE_ADMIN

        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
