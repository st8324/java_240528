package kr.kh.app.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	String me_id; 
	String me_pw; 
	String me_email; 
	String me_authority; 
	int me_fail;
	String me_cookie; 
	Date me_limit; 
	int me_report; 
	String me_ms_name; 
	Date me_stop;

	public MemberVO(String me_id, String me_pw, String me_email) {
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_email = me_email;
	}

}
