package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // ioc 등록 완료 및 파일 리턴하는 컨트롤러
public class AuthController {
    

    @Autowired
    private AuthService authService;
    /*
    public AuthController(AuthService authService){
        this.authService=authService;
    }
    */
    /**
     * 로그인 페이지 이동
     * @return 로그인 페이지
     */
    @GetMapping(value="/auth/signin")
    public String signinform() {
        return "auth/signin";
    }

    /**
     * 회원 가입 페이지 이동
     * @return 회원가입 페이지 이동
     */
    @GetMapping(value="/auth/signup")
    public String signupform() {
        return "auth/signup";
    }
    
    /**
     * 회원가입 요청
     * @return 로그인 페이지
     */
    @PostMapping(value="/auth/signup")
    public String signup(SignupRequestDTO signupRequestDTO) {
        log.info(signupRequestDTO.toString());

        //User <- SignupDto
        User user = signupRequestDTO.toEntity();
        User userEntity = authService.signup(user);
        log.info(user.toString());

        return "auth/signin";
    }
}
