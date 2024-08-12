package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	CommunityVO selectCommunity(@Param("co_num")int coNum);

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	int selectPostTotalCount(@Param("cri")Criteria cri);

	boolean insertPost(@Param("post")PostVO post);

	PostVO selectPost(@Param("po_num")int num);

	void updatePostView(@Param("po_num")int num);

	boolean updatePost(@Param("post")PostVO post);

	boolean deletePost(@Param("po_num")int poNum);

}
