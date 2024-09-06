package kr.kh.spring3.dao;

import java.util.List;

import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	List<PostVO> selectPostList(Criteria cri);

	int selectPostTotalcount(Criteria cri);

	PostVO selectPost(int po_num);

	void updateView(int po_num);

	List<FileVO> selectFileList(int po_num);

	boolean insertPost(PostVO post);

	void insertFile(FileVO fileVo);

	boolean updatePost(PostVO post);

	FileVO selectFile(int fi_num);

	void deleteFile(int fi_num);

	boolean deletePost(int po_num);

}
