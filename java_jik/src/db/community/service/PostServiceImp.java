package db.community.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.community.dao.MemberDAO;
import db.community.dao.PostDAO;
import db.community.model.vo.CommunityVO;

public class PostServiceImp implements PostService {

	private PostDAO postDao;
	
	public PostServiceImp() {
		String resource = "db/community/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertCommunity(String community) {
		//커뮤니티명 null체크, 빈 문자열 체크
		if(community == null || community.trim().length() == 0) {
			return false;
		}
		community = community.trim();
		//중복 확인
		//다오에게 커뮤니티명을 주고 db에 있는 커뮤니티 정보를 달라고 요청
		CommunityVO communityVo = postDao.selectCommunity(community);
		
		//커뮤니티 정보가 null이 아니면 false를 리턴
		if(communityVo != null) {
			return false;
		}
		//다오에게 커뮤니티명을 주고 db에 추가하라고 시킨후 성공 여부를 리턴
		return postDao.insertCommunity(community);
	}
}
