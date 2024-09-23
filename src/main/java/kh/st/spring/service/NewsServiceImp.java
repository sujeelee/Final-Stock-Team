package kh.st.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.st.spring.dao.NewsDAO;

@Service
public class NewsServiceImp implements NewsService{

	@Autowired
	private NewsDAO newsDao; 
}
