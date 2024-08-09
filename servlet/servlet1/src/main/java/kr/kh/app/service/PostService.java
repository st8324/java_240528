package kr.kh.app.service;

import java.util.List;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;

public interface PostService {

	List<CommunityVO> getCommunityList();

	CommunityVO getCommunity(int coNum);

	List<PostVO> getPostList(int coNum);

}
