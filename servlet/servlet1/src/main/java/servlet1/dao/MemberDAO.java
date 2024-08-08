package servlet1.dao;

import org.apache.ibatis.annotations.Param;

import servlet1.model.dto.LoginDTO;

public interface MemberDAO {

	boolean insertMember(@Param("me")LoginDTO member);

}
