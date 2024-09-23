package kh.st.spring.dao;

import kh.st.spring.model.vo.MemberVO;

public interface MemberDAO {

    MemberVO findById(String id);
    
}
