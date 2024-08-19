package kr.kh.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public interface PostService {

	List<CommunityVO> getCommunityList();

	CommunityVO getCommunity(int coNum);

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPageMaker(Criteria cri, int displayPageNum);

	boolean insertPost(PostVO post, ArrayList<Part> files);

	PostVO getPost(int num);

	void updatePostView(int num);

	PostVO getPost(int po_num, MemberVO user);

	boolean updatePost(PostVO post, MemberVO user, List<Part> fileList, String[] numStr);

	boolean deletePost(String po_num, MemberVO user);

	int insertRecommend(RecommendVO recommend);

	RecommendVO getRecommend(int num, MemberVO user);

	List<CommentVO> getCommentList(Criteria cri);

	PageMaker getCommentPageMaker(Criteria cri);

	boolean insertComment(CommentVO comment);

	boolean deleteComment(int co_num, MemberVO user);

	boolean updateComment(CommentVO comment, MemberVO user);

	List<FileVO> getFileList(int num);

}
