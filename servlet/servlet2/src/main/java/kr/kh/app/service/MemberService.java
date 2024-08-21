package kr.kh.app.service;

import kr.kh.app.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	boolean checkId(String me_id);

	MemberVO login(MemberVO member);

}
