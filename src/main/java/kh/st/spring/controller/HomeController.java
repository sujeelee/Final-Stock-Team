package kh.st.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	

	@GetMapping("/")
	public String home() {
		return "/home";//타일즈에서 /*로 했기 때문에 /를 붙임
	}
	

	
}
