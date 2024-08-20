package kr.kh.app.service;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.MemberVO;

public class AdminServiceImp implements AdminService {

	private PostDAO postDao;
	
	public AdminServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {

			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertCommunity(String co_name) {
		try {
			return postDao.insertCommunity(co_name);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCommunity(int co_num, MemberVO user) {
		if(user == null || !user.getMe_authority().equals("ADMIN")) {
			return false;
		}
		return postDao.deleteCommunity(co_num);
	}

	@Override
	public boolean updateCommunity(int co_num, String co_name, MemberVO user) {
		if(user == null || !user.getMe_authority().equals("ADMIN")) {
			return false;
		}
		return postDao.updateCommunity(co_num, co_name);
	}
}
