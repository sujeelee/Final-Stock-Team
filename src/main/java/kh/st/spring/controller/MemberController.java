package kh.st.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.st.spring.model.dto.LoginDTO;
import kh.st.spring.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(){

        return "/member/login";
    }

    @PostMapping("/login")
    public String login_post(Model mo, LoginDTO user_){
    	
    	System.out.println("입력받은 로그인 정보 : " + user_);
        log.info(user_);
        return "/";
    }
}
