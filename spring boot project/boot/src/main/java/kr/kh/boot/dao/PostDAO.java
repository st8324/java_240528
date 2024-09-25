package kr.kh.boot.dao;

import java.util.List;

import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;

public interface PostDAO {

	List<PostVO> selectPostList(int co_num);

	List<CommunityVO> selectCommunityList();
}
