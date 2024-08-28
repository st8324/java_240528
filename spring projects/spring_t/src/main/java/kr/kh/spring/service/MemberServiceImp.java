package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		//정규표현식은 생략 또는 서블릿 프로젝트에서 복붙
		
		
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		//암호화된 비번으로 회원 정보를 수정
		member.setMe_pw(encPw);
		try {
			//아이디 중복, 이메일 중복일 때 예외 발생
			return memberDao.insertMember(member);
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null) {
			return null;
		}
		//matches : 왼쪽에는 암호화 안된 비번, 오른쪽은 암호화된 비번
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean checkId(String id) {
		return memberDao.selectMember(id) == null;
	}


}
