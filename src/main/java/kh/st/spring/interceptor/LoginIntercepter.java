package kh.st.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kh.st.spring.model.vo.MemberVO;

public class LoginIntercepter extends HandlerInterceptorAdapter {

	//실제 handle 이 실행되기 전 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// 구현
		return true;
	}


	//실제 handle 이 수행된 후 실행 (로그인이 실행 된 후)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		//mo에 저장된 user을 가져옴 / model에 있는 user라는 무언가를 가져왔음
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		
		// mo에서 가져온 user가 null일 경우 (로그인 실패시)
		if (user == null) {
			return; //
		}

		//user가 null이 아니면 세션에 저장해 주자 (user로 세션에 저장)
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		//자동로그인 false이면 리턴
		if (!user.isAuto_login()) {
			return; // 
		}

		//auto_login이 true 이므로 쿠키 생성

	}



}
