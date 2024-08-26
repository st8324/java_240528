package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {

	String selectEmail(@Param("me_id")String id);

}
