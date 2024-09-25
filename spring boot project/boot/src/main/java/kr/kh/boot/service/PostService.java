package kr.kh.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.kh.boot.dao.PostDAO;
import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	
	private PostDAO postDao;

	public List<PostVO> getPostList(int co_num) {
		return postDao.selectPostList(co_num);
	}

	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}
}
