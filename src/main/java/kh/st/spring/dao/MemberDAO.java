package kh.st.spring.dao;

import org.apache.ibatis.annotations.Param;

import kh.st.spring.model.vo.MemberVO;

public interface MemberDAO {
    
    MemberVO findById(@Param("id")String id);

    void serUserCookie(@Param("user")MemberVO user);
    
    void add_Fail_Number(@Param("id")String mb_id);
    
    void reset_Fail_Number(@Param("id")String mb_id);
    
}
