package db.community.dao;

import org.apache.ibatis.annotations.Param;

import db.community.model.vo.CommunityVO;

public interface PostDAO {

	CommunityVO selectCommunity(@Param("co_name") String community);

	boolean insertCommunity(@Param("co_name")String community);

}
