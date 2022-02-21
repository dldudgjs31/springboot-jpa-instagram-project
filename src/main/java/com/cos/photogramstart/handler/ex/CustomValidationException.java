package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String message;
    private Map<String,String> errorMap;
    
    public CustomValidationException(String message, Map<String,String> errorMap){
        super(message); // 부모의 클래스에 전달해준다.
        this.errorMap= errorMap;
    }

    public Map<String,String> getErrorMap(){
        return errorMap;
    }
}
