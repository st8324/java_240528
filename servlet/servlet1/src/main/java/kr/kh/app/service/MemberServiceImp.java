package kr.kh.app.service;

import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {

			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(LoginDTO member) {
		if(member == null) {
			return false;
		}
		//아이디 중복 검사해서 있으면 false를 리턴
		if(memberDao.selectMember(member.getId()) != null) {
			return false;
		}
		
		//유효성 검사 실패 시 false를 리턴 
		if(!checkValidate(member)) {
			return false;
		}
		
		//
		try {
			//이메일이 중복되면 추가할 수 없어서(유니크 설정) 예외가 발생
			return memberDao.insertMember(member);
		}catch(Exception e) {
			return false;
		}
	}

	private boolean checkValidate(LoginDTO member) {
		if( member == null || 
			member.getId() == null || 
			member.getPw() == null || 
			member.getEmail() == null) {
			return false;
		}
		//아이디 유효성 검사. 영어, 숫자 6~13
		String idRegex = "\\w{6,13}$";
		if(!Pattern.matches(idRegex, member.getId())) {
			return false;
		}
		//비번 유효성 검사. 영어, 숫자, !@#$ 6~15
		String pwRegex = "^[a-zA-Z0-9!@#$]{6,15}$";
		if(!Pattern.matches(pwRegex, member.getPw())) {
			return false;
		}
		//이메일 유효성 검사.
		String emailRegex = "^[A-Za-z0-9_]+@[A-Za-z0-9_]+(\\.[A-Za-z]{2,}){1,}$";
		if(!Pattern.matches(emailRegex, member.getEmail())) {
			return false;
		}
		return true;
	}

	@Override
	public MemberVO login(LoginDTO member) {
		if(member == null) {
			return null;
		}
		//다오에게 아이디를 주면서 아이디와 일치하는 회원 정보를 가져오라고 시킴
		MemberVO user = memberDao.selectMember(member.getId());
		//가져온 회원 정보가 null이면 null을 리턴
		if(user == null) {
			return null;
		}
		//비번과 가져온 회원정보의 비번이 같으면 가져온 회원 정보를 리턴
		if(user.getMe_pw().equals(member.getPw())) {
			return user;
		}
		//다르면 null을 리턴 
		return null;
	}
}
