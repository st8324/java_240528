package db.community.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.community.dao.MemberDAO;
import db.community.model.vo.MemberVO;
import db.student.dao.SubjectDAO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "db/community/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO login(String id, String pw) {
		//다오에게 아이디를 주고 회원 가져오라고 시킴
		MemberVO user = memberDao.selectMember(id);
		//가져온 회원 정보가 없으면 null을 리턴
		if(user == null) {
			return null;
		}
		//회원 정보가 있으면 회원의 비번과 입력받은 비번을 확인해서 같으면 회원정보를 반환
		if(user.getMe_pw().equals(pw)) {
			//로그인 실패 횟수를 0으로 수정
			memberDao.updateFail(user.getMe_id(), 0);
			return user;
		}
		//로그인 실패 횟수를 1 증가
		memberDao.updateFail(user.getMe_id(), 1);
		//다르면 null을 반환
		return null;
	}

	@Override
	public boolean signup(String id, String pw, String email) {
		//아이디 중복 검사
		//다오에게 아이디를 주면서 회원 정보를 가져오라고 시켜서 있으면 false를 리턴
		MemberVO user = memberDao.selectMember(id);
		if(user != null) {
			return false;
		}
		//아이디가 정규 표현식에 맞지 않으면 false를 리턴
		String idRegex = "^\\w{6,13}$";
		if(!Pattern.matches(idRegex, id)) {
			return false;
		}
		//비번이 정규 표현식에 맞지 않으면 false를 리턴
		String pwRegex = "^[a-zA-Z0-9!@#$]{6,15}$";
		if(!Pattern.matches(pwRegex, pw)) {
			return false;
		}
		//다오에게 아이디, 비번, 이메일을 주면서 회원가입하라고 시킴
		return memberDao.insertMember(id, pw, email);
	}
}
