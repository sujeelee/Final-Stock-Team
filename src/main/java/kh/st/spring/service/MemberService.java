package kh.st.spring.service;

import kh.st.spring.model.dto.JoinDTO;
import kh.st.spring.model.dto.LoginDTO;
import kh.st.spring.model.vo.MemberVO;

public interface MemberService {

    MemberVO login(LoginDTO user_);

    void setUserCookie(MemberVO user);

    Boolean join(JoinDTO user_);
    
}
