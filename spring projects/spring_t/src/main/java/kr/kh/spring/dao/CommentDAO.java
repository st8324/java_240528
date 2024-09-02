package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.pagination.Criteria;

public interface CommentDAO {

	boolean insertComment(@Param("comment")CommentVO comment);

	List<CommentVO> seelctCommentList(@Param("cri")Criteria cri);

	int selectCommentTotalCount(@Param("cri")Criteria cri);

	boolean deleteComment(@Param("cm_num")int cm_num);

	CommentVO selectComment(@Param("cm_num")int cm_num);

	boolean updateComment(@Param("comment")CommentVO comment);

}
