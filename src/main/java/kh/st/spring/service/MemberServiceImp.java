package kh.st.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.st.spring.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService {
    
    @Autowired
    private MemberDAO memberDao;

    
}
