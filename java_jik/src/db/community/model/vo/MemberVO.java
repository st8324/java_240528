package db.community.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {

	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_authority;
	private int me_fail; 
	private String me_cookie; 
	private Date datetime; 
	private int me_report; 
	private String me_ms_name; 
	private Date me_stop;
}
