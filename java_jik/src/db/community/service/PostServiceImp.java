package db.community.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.community.dao.MemberDAO;
import db.community.dao.PostDAO;
import db.community.model.vo.CommentVO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;

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

	@Override
	public boolean updateCommunity(String oldName, String newName) {
		//이전 커뮤니티명과 이후 커뮤니티명 중에 null이 있거나 이후 커뮤니티명의 길이가 0이면 false를 리턴 
		if(oldName == null || newName == null || newName.trim().length() == 0) {
			return false;
		}
		//이전 커뮤니티명과 이후 커뮤니티명이 같으면 false를 리턴
		if(oldName.equals(newName)) {
			return false;
		}
		//등록된 커뮤니티명이어야 수정할 수 있다
		//이전 커뮤니티명을 이용해서 커뮤니티VO를 가져옴
		CommunityVO oldVo = postDao.selectCommunity(oldName);
		
		//커뮤니티VO가 null이면 false를 리턴
		if(oldVo == null) {
			return false;
		}
		
		//바꾸려는 커뮤니티명이 이미 등록되어있으면 수정할 수 없다 
		//이후 커뮤니티명을 이용해서 커뮤니티VO를 가져옴
		CommunityVO newVo = postDao.selectCommunity(newName);
		//이후 커뮤니티VO가 null이 아니면 false를 리턴
		if(newVo != null) {
			return false;
		}
		//이전 커뮤니티VO의 커뮤니티명을 이후 커뮤니티명으로 수정
		oldVo.setCo_name(newName.trim());
		//다오에게 이전커뮤니티VO를 주면서 커뮤니티명을 수정하라고 요청하고 처리 여부를 반환
		return postDao.updateCommunity(oldVo);
	}

	@Override
	public boolean deleteCommunity(String name) {
		//등록된 커뮤니티수가 1이면 false를 리턴 
		List<CommunityVO> list = postDao.selectCommunityList();
		if(list.size() == 1) {
			return false;
		}
		
		//다오에게 커뮤니티명을 주면서 삭제하라고 요청 후 삭제 여부를 반환
		return postDao.deleteCommunity(name);
	}

	@Override
	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	@Override
	public boolean insertPost(PostVO post) {
		//게시글VO null체크해서 문제 있으면 false를 리턴
		if(post == null) {
			return false;
		}
		//제목 null체크, 빈문자열 체크해서 문제 있으면 false를 리턴
		if(!checkString(post.getPo_title())) {
			return false;
		}
		//내용 null체크, 빈문자열 체크해서 문제 있으면 false를 리턴
		if(!checkString(post.getPo_content())) {
			return false;
		}
		//다오에게 게시글 VO를 주면서 게시글을 등록하라고 요청한 후 성공 여부를 반환
		try {
			return postDao.insertPost(post);
		}catch(Exception e) {
			return false;
		}
	}
	//문자열이 null이거나 공백으로 된 문자열이면 false, 아니면 true
	private boolean checkString(String str) {
		if(str == null || str.trim().length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			throw new RuntimeException();
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PostVO getPost(int poNum) {
		return postDao.selectPost(poNum);
	}

	@Override
	public int selectPostListTotalCount(Criteria cri) {
		if(cri == null) {
			return 0;
		}
		return postDao.selectPostListCount(cri);
	}

	@Override
	public boolean deletePost(int po_num) {
		return postDao.deletePost(po_num);
	}

	@Override
	public boolean updatePost(PostVO post) {
		if(post == null) {
			return false;
		}
		if(!checkString(post.getPo_title()) || !checkString(post.getPo_content())) {
			return false;
		}
		return postDao.updatePost(post);
	}

	@Override
	public boolean insertCommnet(CommentVO comment) {
		if(comment == null) {
			return false;
		}
		if(!checkString(comment.getCm_content())) {
			return false;
		}
		return postDao.insertComment(comment);
	}

	@Override
	public List<CommentVO> getCommentList(int po_num) {
		return postDao.selectCommentList(po_num);
	}

	@Override
	public void updatePostView(int poNum) {
		postDao.updatePostView(poNum);
		
	}
}
