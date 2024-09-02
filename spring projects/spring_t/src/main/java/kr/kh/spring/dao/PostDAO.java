package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PostCriteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	List<PostVO> selectPostList(@Param("cri")PostCriteria cri);

	int selectPostTotalCount(@Param("cri")PostCriteria cri);

	boolean insertPost(@Param("post")PostVO post);

	void insertFile(@Param("file")FileVO fileVo);

	void updateView(@Param("po_num")Integer po_num);

	PostVO selectPost(@Param("po_num")Integer po_num);

	List<FileVO> selectFileList(@Param("po_num")Integer po_num);

	FileVO selectFile(@Param("fi_num")int fi_num);

	void deleteFile(@Param("fi_num")int fi_num);

	boolean updatePost(@Param("post")PostVO post);

	boolean deletePost(@Param("po_num")int po_num);

	boolean insertCommunity(@Param("co_name")String name);

}
