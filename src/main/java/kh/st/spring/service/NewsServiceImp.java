package kh.st.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.st.spring.dao.NewsDAO;
import kh.st.spring.model.vo.NewsVO;

@Service
public class NewsServiceImp implements NewsService{

	@Autowired
	private NewsDAO newsDao;

	@Override
	public List<NewsVO> getNewsList(Date ne_datetime) {
		if(ne_datetime == null) {
			return null;
		}
		return newsDao.selectNewsList(ne_datetime);
	} 
}
