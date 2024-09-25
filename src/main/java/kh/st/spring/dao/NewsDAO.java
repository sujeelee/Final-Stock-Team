package kh.st.spring.dao;

import java.util.List;

import kh.st.spring.model.vo.NewsVO;

public interface NewsDAO {

	List<NewsVO> selectNewsList(String formatDate);

}
