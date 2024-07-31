package db.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;

public interface PostDAO {

	CommunityVO selectCommunity(@Param("co_name") String community);

	boolean insertCommunity(@Param("co_name")String community);

	boolean updateCommunity(@Param("vo")CommunityVO oldVo);

	boolean deleteCommunity(@Param("co_name")String name);

	List<CommunityVO> selectCommunityList();

	boolean insertPost(@Param("po")PostVO post);

}
