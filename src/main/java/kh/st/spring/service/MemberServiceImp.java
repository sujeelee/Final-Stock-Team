package kh.st.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.st.spring.dao.MemberDAO;
import kh.st.spring.model.dto.LoginDTO;
import kh.st.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
    
    @Autowired
    private MemberDAO memberDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public MemberVO login(LoginDTO user_) {
        //null일시 리턴
        if (user_ == null) {
            return null;
        }
        //id가 비었거나, 공백처리 되어있으면 DB처리할 필요 없이 리턴
        if (user_.getId() == null || user_.getId().trim().length() == 0) {
            return null;
        }
        //pw가 비었거나, 공백처리 되어있으면 DB확인하지 않고 리턴
        if (user_.getPw() == null || user_.getPw().trim().length() == 0) {
            return null;
        }
        //re가 on이면 쿠키 제작
        if (user_.getRe().equals("on")) {
            // 후추
            // fn : Cookie_mk(user_);
        }
        //id 로 회원정보 DB에서 가져오기
        MemberVO user = findById(user_.getId());

        //일치하는 아이디가 없으면 null
        if (user == null) {
            return null;
        }
        //입력한 비번이, 인코딩 된 비번과 일치하는지 확인
        if (passwordEncoder.matches(user_.getPw(), user.getMb_password())) {
            //다 일치하면
            return user;
        }
        return null;
    }

    private MemberVO findById(String id) {
        MemberVO findUser = memberDao.findById(id);
        return findUser;//없으면 null 리턴
    }

    
}
