package kr.kh.app.service;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public class PostServiceImp implements PostService {

	private PostDAO postDao;
	
	public PostServiceImp() {
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
	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	@Override
	public CommunityVO getCommunity(int coNum) {
		return postDao.selectCommunity(coNum);
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			throw new RuntimeException();
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		if(cri == null) {
			throw new RuntimeException();
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(totalCount, displayPageNum, cri);
	}

	@Override
	public boolean insertPost(PostVO post) {
		if(post == null) {
			return false;
		}
		if(post.getPo_title() == null || post.getPo_title().trim().length() == 0) {
			return false;
		}
		if(post.getPo_content() == null || post.getPo_content().trim().length() == 0) {
			return false;
		}
		return postDao.insertPost(post);
	}

	@Override
	public PostVO getPostList(int num) {
		return postDao.selectPost(num);
	}

	@Override
	public void updatePostView(int num) {
		postDao.updatePostView(num);
	}

}
