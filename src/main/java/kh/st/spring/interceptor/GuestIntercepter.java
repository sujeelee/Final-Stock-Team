package kh.st.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kh.st.spring.model.vo.MemberVO;

public class GuestIntercepter extends HandlerInterceptorAdapter {

    // login 페이지와 join 페이지 입장 하였을 때
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // user가 세션에 저장되어 있나요?
        MemberVO user = (MemberVO) request.getSession().getAttribute("user");

        // 유저 정보가 있으면 들어갈 수 없습니다.
        if (user != null) {
            response.sendRedirect(request.getContextPath() + "/"); // home으로
            return false;
        }
        // 유저 정보가 없으면 login, join으로 이동
        return true;
    }

}