package db.community.service;

import java.util.List;

import db.community.model.vo.CommentVO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;

public interface PostService {

	boolean insertCommunity(String community);

	boolean updateCommunity(String oldName, String newName);

	boolean deleteCommunity(String name);

	List<CommunityVO> getCommunityList();

	boolean insertPost(PostVO post);

	List<PostVO> getPostList(Criteria cri);

	PostVO getPost(int poNum);

	int selectPostListTotalCount(Criteria cri);

	boolean deletePost(int po_num);

	boolean updatePost(PostVO post);

	boolean insertCommnet(CommentVO comment);

	List<CommentVO> getCommentList(int po_num);

	void updatePostView(int poNum);

}
