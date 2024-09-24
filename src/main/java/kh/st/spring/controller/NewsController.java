package kh.st.spring.controller;

import java.util.HashMap;
import java.util.List;
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
	public Map<String, List<NewsVO>> views(@RequestBody NewsVO news){
		log.info("newspaper/views:post");
		log.info(news);
		Map<String, List<NewsVO>> map = new HashMap<String, List<NewsVO>>();
		// 서비스에게 날짜를 주고 리스트를 가져옴
		List<NewsVO> newsList = newsService.getNewsList(news.getNe_datetime());
		log.info(newsList);
		map.put("newsList", newsList);
		return map;
	}
}
