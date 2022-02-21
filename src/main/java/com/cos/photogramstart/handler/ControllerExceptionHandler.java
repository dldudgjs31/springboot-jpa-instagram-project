package com.cos.photogramstart.handler;

import java.util.Map;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.utils.Script;
import com.cos.photogramstart.web.dto.CRMRespDto;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice // 모든 exception을 가로채온다.
public class ControllerExceptionHandler {
    
    /*
    @ExceptionHandler(CustomValidationException.class)
    public CRMRespDto<?> validationException(CustomValidationException e){
        return new CRMRespDto<Map<String,String>>(-1,e.getMessage(),e.getErrorMap());
    }*/

    /**
     * 예외처리 상황에서 스크립트로 응답
     * 1. 클라이언트 응답시엔 script
     * 2. Ajax 통신에는 위의 방법이 나음
     * @param e
     * @return 에러메세지 스크립트로 반환
     */
    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e){
        return Script.back(e.getErrorMap().toString());

    }
}
