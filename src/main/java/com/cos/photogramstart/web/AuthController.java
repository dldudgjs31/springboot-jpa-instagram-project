package com.cos.photogramstart.web;

import com.cos.photogramstart.web.dto.auth.SignupRequestDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // ioc 등록 완료 및 파일 리턴하는 컨트롤러
public class AuthController {
    
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

        return "auth/signin";
    }
}
