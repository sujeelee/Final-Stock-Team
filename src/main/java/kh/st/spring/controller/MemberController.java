package kh.st.spring.controller;

import javax.servlet.http.HttpSession;

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
        //화면 미구현
        return "/member/login";
    }

    @PostMapping("/login")
    public String login_post(Model mo, LoginDTO user_, HttpSession session){
    	//화면에서 id, pw, re(자동로그인 여부 => on, null로 값이 전달됨) 가져옴
    	System.out.println("입력받은 로그인 정보 : " + user_);

        //받은 정보를 DB에서 있는지 없는지 확인 함 
        MemberVO user = memberService.login(user_);

        //
        if (user != null) {
            
        } else {

        }





        log.info(user);
        return "/home";
    }
    
    
    //회원가입
    @GetMapping("/join")
    public String join(){
    	//화면 미구현
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
