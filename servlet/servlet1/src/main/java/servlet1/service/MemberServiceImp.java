package servlet1.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import servlet1.dao.MemberDAO;
import servlet1.model.dto.LoginDTO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "servlet1/config/mybatis-config.xml";
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
	public boolean signup(LoginDTO member) {
		if(member == null) {
			return false;
		}
		//유효성 검사 실패 시 false를 리턴 
		
		//
		return memberDao.insertMember(member);
	}
}
