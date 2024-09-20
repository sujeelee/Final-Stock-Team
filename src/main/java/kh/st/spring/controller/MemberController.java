package kh.st.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kh.st.spring.model.dto.LoginDTO;
import kh.st.spring.service.MemberService;

@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(){

        return "/member/login";
    }

    @PostMapping("/login")
    public String login_post(Model mo, LoginDTO user_){

        return "/member/login";
    }
}
