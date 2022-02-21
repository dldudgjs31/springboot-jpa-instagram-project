package com.cos.photogramstart.web.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CRMRespDto<T> {
    
    private int code; //1 은 성공, -1 은 실패
    private String message;
    private T data;
}
