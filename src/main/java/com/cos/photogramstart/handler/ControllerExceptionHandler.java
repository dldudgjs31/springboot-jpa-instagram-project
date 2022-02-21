package com.cos.photogramstart.handler;

import java.util.Map;

import com.cos.photogramstart.handler.ex.CustomValidationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice // 모든 exception을 가로채온다.
public class ControllerExceptionHandler {
    
    @ExceptionHandler(CustomValidationException.class)
    public Map<String,String> validationException(CustomValidationException e){
        return e.getErrorMap();
    }
}