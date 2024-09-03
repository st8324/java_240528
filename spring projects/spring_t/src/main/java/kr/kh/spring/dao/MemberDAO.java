package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("m")MemberVO member);

	MemberVO selectMember(@Param("me_id")String me_id);

	void updateMemberCookie(@Param("user")MemberVO user);

	MemberVO selectMemberByCookie(@Param("me_cookie")String sid);

	boolean updateMember(@Param("user")MemberVO user);



}
