package com.cos.photogramstart.domain.user;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor // 파라미터 없는 기본 생성자
@AllArgsConstructor // 모든 필드값을 받는 생성자
@Data
@Entity // db table 생성
public class User {
    @Id //pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략 설정 (연결된 db에 따라 다름)
    private int id;

    //@Max(20)
    @Column(length = 20,unique=true)
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    @Column(unique=true,nullable = false)
    private String email;

    private String website;

    private String bio; // 자기소개

    @Column(unique=true)
    private String phone;

    private String gender; // 성별

    private String profileImageUrl; //사진
    
    private String role; //권한

    private LocalDateTime createDate;


    /**
     * data insert 직전에 실행되는 어노테이션
     */
    @PrePersist
    public void creatTime(){
        this.createDate=LocalDateTime.now();
    }
}
