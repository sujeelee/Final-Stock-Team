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
        //id 로 회원정보 DB에서 가져오기
        MemberVO user = findById(user_.getId());

        //일치하는 아이디가 없으면 null
        if (user == null) {
            return null;
        }
        //입력한 비번이, 인코딩 된 비번과 일치하는지 확인
        if (passwordEncoder.matches(user_.getPw(), user.getMb_password())) {
            //다 일치하면 fail 횟수 0 (String id 값을 넘겨주도록 하겠습니다.)
            memberDao.reset_Fail_Number(user.getMb_id());
            //유저 반환
            return user;
        }
        //id는 있는데 비번이 불일치 되었을 시 fail + 1
        memberDao.add_Fail_Number(user.getMb_id());

        return null;
    }  
    // id로 유저 찾기
    private MemberVO findById(String id) {
        MemberVO findUser = memberDao.findById(id);
        return findUser;//없으면 null 리턴
    }

    // 쿠키정보만 수정합니다.
    @Override
    public void setUserCookie(MemberVO user) {
        if (user == null) {
            return;
        }

        memberDao.serUserCookie(user);
    }

    
}
