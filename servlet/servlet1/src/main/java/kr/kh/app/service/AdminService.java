package kr.kh.app.service;

import kr.kh.app.model.vo.MemberVO;

public interface AdminService {

	boolean insertCommunity(String co_name);

	boolean deleteCommunity(int co_num, MemberVO user);

}
