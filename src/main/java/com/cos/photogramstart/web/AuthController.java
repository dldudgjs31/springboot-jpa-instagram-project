package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String signup(@Valid SignupRequestDTO signupRequestDTO,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error: bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
                System.out.println("#################################################################");
                System.out.println(error.getDefaultMessage());
                System.out.println("#################################################################");

            }
            throw new CustomValidationException("유효성 실패",errorMap);
        }else{
           //User <- SignupDto 
            User user = signupRequestDTO.toEntity();
            User userEntity = authService.signup(user);
            log.info("massage",userEntity);

            return "auth/signin";
        }

    }
}
