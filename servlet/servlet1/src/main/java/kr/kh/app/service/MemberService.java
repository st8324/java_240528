package kr.kh.app.service;

import kr.kh.app.model.dto.LoginDTO;

public interface MemberService {

	boolean signup(LoginDTO member);

}
