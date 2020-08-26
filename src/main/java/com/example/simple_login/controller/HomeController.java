package com.example.simple_login.controller;

import com.example.simple_login.domain.Member;
import com.example.simple_login.dto.MemberDto;
import com.example.simple_login.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @RequestMapping("/")//home
    public String home(){
        return "home";
    }

    //회원가입
    @GetMapping("/users/signup")
    public String form(){
        return "form";
    }

    //회원가입 결과
    @PostMapping("/users/signup")
    public String createUser(MemberDto memberDto){
        memberService.joinUser(memberDto);
        return "home";
    }

    //show List
    @GetMapping("/users/list")
    public String list(Model model){
        List<Member> members = memberService.findAll();
        List<MemberDto> dtos = members.stream()
                .map(m -> new MemberDto(m.getId(), m.getUsername()))
                .collect(Collectors.toList());
        model.addAttribute("members", dtos);
        return "list";
    }

    // 로그인
    @GetMapping("/users/login")
    public String loginForm(){
        return "login";
    }

    // 로그인 결과 페이지
    @GetMapping("/users/login/result")
    public String loginResult() {
        return "/loginSuccess";
    }

    //로그아웃 결과 페이지
    @GetMapping("/users/logout/result")
    public String logoutResult() {
        return "/logoutSuccess";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보
    @GetMapping("/users/info")
    public String dispMyInfo() {
        return "/myInfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }

}
