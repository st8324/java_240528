package db.community.service;

import java.util.List;

import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;

public interface PostService {

	boolean insertCommunity(String community);

	boolean updateCommunity(String oldName, String newName);

	boolean deleteCommunity(String name);

	List<CommunityVO> getCommunityList();

	boolean insertPost(PostVO post);

}
