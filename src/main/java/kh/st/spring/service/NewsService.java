package kh.st.spring.service;

import java.util.Date;
import java.util.List;

import kh.st.spring.model.vo.NewsPaperVO;
import kh.st.spring.model.vo.NewsVO;

public interface NewsService {

	List<NewsVO> getNewsList(Date ne_datetime);

	NewsPaperVO getNewsPaper(int np_no);

}
