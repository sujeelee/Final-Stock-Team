package kh.st.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kh.st.spring.service.MemberService;

@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;
}
