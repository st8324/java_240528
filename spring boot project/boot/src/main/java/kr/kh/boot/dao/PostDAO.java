package kr.kh.boot.dao;

import java.util.List;

import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.pagination.PostCriteria;

public interface PostDAO {

	List<PostVO> selectPostList(PostCriteria cri);

	List<CommunityVO> selectCommunityList();

	int selectCountPostList(PostCriteria cri);
}
