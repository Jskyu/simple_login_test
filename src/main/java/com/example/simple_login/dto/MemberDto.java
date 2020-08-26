package com.example.simple_login.dto;

import com.example.simple_login.domain.Member;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String username;
    private String password;

    public MemberDto(){}

    public MemberDto(Long id, String username){
        this.id = id;
        this.username = username;
    }

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
