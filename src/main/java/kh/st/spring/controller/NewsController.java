package kh.st.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.st.spring.service.NewsService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/newspaper")
public class NewsController {

	@Autowired
	NewsService newsService;
	
	@GetMapping("/list/{np_no}")
	public String list(Model model, @PathVariable("np_no")int np_no) {
		log.info("newspaper/list:get");
		log.info(np_no);
		
		return "/newspaper/list";
	}
}
