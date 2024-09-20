package kh.st.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.st.spring.model.dto.LoginDTO;
import kh.st.spring.model.vo.MemberVO;
import kh.st.spring.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    private MemberService memberService;
    
    
    //로그인
    @GetMapping("/login")
    public String login(){

        return "/member/login";
    }

    @PostMapping("/login")
    public String login_post(Model mo, LoginDTO user_){
    	
    	System.out.println("입력받은 로그인 정보 : " + user_);
        log.info(user_);
        return "/home";
    }
    
    
    //회원가입
    @GetMapping("/join")
    public String join(){
    	
    	return "/member/join";
    }
    
    
    @PostMapping("/join")
    public String join_post(Model mo, LoginDTO user_) {
    	//LoginDTO를 나중에 MemberVO로 바꾸어 주세용
    	System.out.println("회원가입시 정보 : " + user_);
    	log.info(user_);
    	
    	return "/home";
    }
}
