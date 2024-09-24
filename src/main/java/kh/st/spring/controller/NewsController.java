package kh.st.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.st.spring.model.vo.NewsVO;
import kh.st.spring.service.NewsService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/newspaper")
public class NewsController {

	@Autowired
	NewsService newsService;
	
	@GetMapping("/home")
	public String home(Model model) {
		log.info("newspaper/home:get");
		
		return "/newspaper/home";
	}
	
	@ResponseBody
	@PostMapping("/views")
	public Map<String, Object> views(@RequestBody NewsVO newsVo){
		log.info("newspaper/views:post");
		log.info(newsVo);
		Map<String, Object> map = new HashMap<String, Object>();
		// 서비스에게 
		
		return map;
	}
}
