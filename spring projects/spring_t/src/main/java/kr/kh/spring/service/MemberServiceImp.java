package kr.kh.spring.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
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

	@Override
	public void updateMemberCookie(MemberVO user) {
		if(user==null) {
			return;
		}
		memberDao.updateMemberCookie(user);
	}

	@Override
	public MemberVO getMemberByCookie(String sid) {
		return memberDao.selectMemberByCookie(sid);
	}

	@Override
	public boolean findPw(String id) {
		//임시 새 비밀번호를 생성
		String newPw = randomPassword(8);
		//메일로 전송
		MemberVO user = memberDao.selectMember(id);
		if(user == null) {
			return false;
		}
		
		mailSend(
				user.getMe_email(), 
				"새 임시 비밀번호입니다.", 
				"새 임시 비밀번호는 <b>" + newPw + "</b>입니다.");
		//성공하면 DB에 새 비번을 암호화해서 수정
		String encPw = passwordEncoder.encode(newPw);
		user.setMe_pw(encPw);
		return memberDao.updateMember(user);
	}

	private String randomPassword(int size) {
		String pw = "";
		int max = 10 + 26 + 26;
		while(pw.length() < size) {
			Random random = new Random();
			int r = random.nextInt(max);
			//0~9
			if(r < 10) {
				pw += r;
			}
			//10~35 : a~z
			else if(r < 36) {
				pw += (char)('a' + r - 10);
			}
			//36~61 : A~Z
			else {
				pw += (char)('A' + r - 36);
			}
		}
		return pw;
	}

	public boolean mailSend(String to, String title, String content) {

	    String setfrom = "stajun@naver.com";
	   try{
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(to);// 받는사람 이메일
	        messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
	        messageHelper.setText(content, true);// 메일 내용

	        mailSender.send(message);
	        return true;
	    } catch(Exception e){
	        e.printStackTrace();
	        return false;
	    }
	}
	
}
