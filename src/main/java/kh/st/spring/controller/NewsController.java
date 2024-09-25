package kh.st.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.st.spring.model.vo.NewsPaperVO;
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
		Map<String, List<NewsVO>> map = new HashMap<String, List<NewsVO>>();
		// 서비스에게 날짜를 주고 리스트를 가져옴
		List<NewsVO> newsList = newsService.getNewsList(news.getNe_datetime());
		map.put("newsList", newsList);
		return map;
	}
	
	@GetMapping("/list/{np_no}")
	public String list(Model model, @PathVariable("np_no") int np_no) {
		log.info("newspaper/list:get");
		NewsPaperVO newspaper = newsService.getNewsPaper(np_no);
		log.info(newspaper);
		model.addAttribute("newspaper",newspaper);
		return "/newspaper/list";
	}
}
