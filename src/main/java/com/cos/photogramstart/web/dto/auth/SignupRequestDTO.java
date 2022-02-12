package com.cos.photogramstart.web.dto.auth;

import lombok.Data;

@Data //getter setter
public class SignupRequestDTO {
    private String username;
    private String password;
    private String email;
    private String name;
}
