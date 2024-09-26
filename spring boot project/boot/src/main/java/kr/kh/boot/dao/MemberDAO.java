package kr.kh.boot.dao;

import kr.kh.boot.model.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(String id);

}
