package kh.st.spring.interceptor;

import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kh.st.spring.model.vo.MemberVO;
import kh.st.spring.service.MemberService;


public class LoginIntercepter extends HandlerInterceptorAdapter {

	@Autowired
	private MemberService memberService;


	//실제 handle 이 수행된 후 실행 (로그인이 실행 된 후)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//Login_post와 순서 체크를 위한 디버깅 용 syso
		System.out.println("post Login 인터셉터 입니다.");

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
		//각 유저의 session id를 가져오자
		// ! session : 서버에 저장되어 있고 보안이 좋은 각 유저를 관리하는 기능
		String sid = session.getId();

		//sid값을 가진 AUTO_LOGIN 쿠키 생성
		Cookie cookie = new Cookie("AUTO_LOGIN", sid);

		//쿠키 기간 (초, 분, 시, 일)
		int time = 60 * 60 * 24 * 7; //만료기간 7일
		//임계 값
		cookie.setMaxAge(time);
		//쿠키가 사용될 경로 (uri : / 모든경로)
		cookie.setPath("/");

		// -- DB에 쿠키저오 저장 -- 
		Date date = new Date(System.currentTimeMillis() + time * 1000);
		//DB에 세팅할 정보들 기록 (sid : 세션 아이디, limil : 쿠키 만료 기간)
		user.setMb_cookie(sid);
		user.setMb_cookie_limit(date);

		//DB user 정보에 쿠키 정보 기록
		memberService.setUserCookie(user);

		//response로 쿠키를 전송
		response.addCookie(cookie);
	}


}
