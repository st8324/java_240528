package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;

@Service
public class CommentService {

	@Autowired
	CommentDAO commentDao;

	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null) {
			return false;
		}
		comment.setCm_me_id(user.getMe_id());
		return commentDao.insertComment(comment);
	}

	public List<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return commentDao.seelctCommentList(cri);
	}

	public PageMaker getCommentPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount = commentDao.selectCommentTotalCount(cri);
		return new PageMaker(5, cri, totalCount);
	}

	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(user == null || comment == null) {
			return false;
		}
		return commentDao.deleteComment(comment.getCm_num());
	}

	public boolean deleteComment(int cm_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		if(!isWriter(cm_num, user.getMe_id())) {
			return false;
		}
		return commentDao.deleteComment(cm_num);
	}

	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(user == null || comment == null) {
			return false;
		}
		if(!isWriter(comment.getCm_num(), user.getMe_id())) {
			return false;
		}
		return commentDao.updateComment(comment);
	}
	public boolean isWriter(int cm_num, String me_id) {
		CommentVO comment = commentDao.selectComment(cm_num);
		if(comment == null ) {
			return false;
		}
		return comment.getCm_me_id().equals(me_id);

	}
}
