package db.community.service;

public interface PostService {

	boolean insertCommunity(String community);

	boolean updateCommunity(String oldName, String newName);

	boolean deleteCommunity(String name);

}
