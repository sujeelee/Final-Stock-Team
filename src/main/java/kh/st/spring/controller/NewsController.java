package kh.st.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.st.spring.service.NewsService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/newspaper")
public class NewsController {

	@Autowired
	NewsService newsService;
	
	@GetMapping("/home")
	public String list(Model model) {
		log.info("newspaper/list:get");
		// 뉴스페이퍼 리스트를 가져옴
		
		// 화면에 넘겨줌
		
		return "/newspaper/home";
	}
}
