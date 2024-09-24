package kh.st.spring.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
    private int mb_no; //(11자리), auto_incre
    private String mb_id;
    private String mb_password;
    private String mb_name;
    private String mb_nick;
    private String mb_hp;
    private String mb_email;
    private int mb_zip; //(11자리)
    private String mb_addr;
    private String mb_addr2;
    private int mb_birth; //(11자리) 생일이 int로 ERD에 적혀있어서 그래도 했습니다.
    private int mb_level; //(11자리)
    private Date mb_datetime;
    private Date mb_edit_date;
    private Date mb_stop_date;
    private Date mb_out_date;
    private String mb_cookie;
    private int mb_point; //(11자리)
    private byte mb_emailing;
    private String mb_account;
    private boolean auto_login; // autoLogin, DB에는 없습니다.
}
