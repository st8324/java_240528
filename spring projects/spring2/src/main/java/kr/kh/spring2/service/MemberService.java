package kr.kh.spring2.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.MemberDAO;
import kr.kh.spring2.model.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public boolean signup(MemberVO member) {
		if(member==null) {
			return false;
		}
		if(!checkRegex(member.getMe_id(), "^\\w{6,13}$")) {
			return false;
		}
		if(!checkRegex(member.getMe_pw(), "^[a-zA-Z0-9!@#$]{6,15}$")) {
			return false;
		}
		try {
			String encPw = passwordEncoder.encode(member.getMe_pw());
			member.setMe_pw(encPw);
			return memberDao.insertMember(member);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean checkRegex(String str, String regex) {
		if(str != null && Pattern.matches(regex, str)) {
			return true;
		}
		return false;
	}

	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null) {
			return null;
		}
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;
	}
}
