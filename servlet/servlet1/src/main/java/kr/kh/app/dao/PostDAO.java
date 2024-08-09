package kr.kh.app.dao;

import java.util.List;

import kr.kh.app.model.vo.CommunityVO;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

}
