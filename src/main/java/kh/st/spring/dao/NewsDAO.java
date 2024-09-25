package kh.st.spring.dao;

import java.util.List;

import kh.st.spring.model.vo.NewsPaperVO;
import kh.st.spring.model.vo.NewsVO;

public interface NewsDAO {

	List<NewsVO> selectNewsList(String formatDate);

	NewsPaperVO selectNewsPaper(int np_no);

}
