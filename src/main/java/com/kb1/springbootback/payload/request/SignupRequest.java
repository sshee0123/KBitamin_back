package com.kb1.springbootback.payload.request;

import lombok.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {

    // 회원가입 할 때 필요한 정보들
    // 유저 아이디
    @NotBlank
    @Size(min = 5, max = 20)
    private String id;

    
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


    // 핸드폰 번호
    // private String phone;

    // 성별
    private String sex;

    // 생일
    private Date birthDate;

}