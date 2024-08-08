package kr.kh.app.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("me")LoginDTO member);

	MemberVO selectMember(@Param("id")String id);

}
