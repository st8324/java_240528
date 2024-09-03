package kr.kh.spring.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class PostService {

	@Autowired
	PostDAO postDao;
	@Resource
	String uploadPath;

	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	public List<PostVO> getPostList(PostCriteria cri) {
		if(cri == null) {
			return null;
		}
		return postDao.selectPostList(cri);
	}

	public PageMaker getPageMaker(PostCriteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount =  postDao.selectPostTotalCount(cri);
		return new PageMaker(3, cri, totalCount);
	}

	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		if(post == null || user == null) {
			return false;
		}
		boolean res;
		try {
			post.setPo_me_id(user.getMe_id());
			res = postDao.insertPost(post);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		if(!res) {
			return false;
		}

		if(fileList == null || fileList.length == 0) {
			return true;
		}
		//첨부파일 추가
		for(MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		return true;
	}

	private void uploadFile(MultipartFile file, int po_num) {

		if(file == null || file.getOriginalFilename().length() == 0) {
			return;
		}
		
		try {
			String fi_ori_name = file.getOriginalFilename();
			//첨부파일을 서버에 업로드 후 경로가 포함된 파일명을 가져옴
			String fi_name = 
			UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
			//DB에 첨부파일 정보를 추가
			FileVO fileVo = new FileVO(fi_name, fi_ori_name, po_num);
			postDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateView(Integer po_num) {
		postDao.updateView(po_num);
	}

	public PostVO getPost(Integer po_num) {
		return postDao.selectPost(po_num);
	}

	public List<FileVO> getFileList(Integer po_num) {
		return postDao.selectFileList(po_num);
	}

	public boolean updatePost(PostVO post, int[] fi_nums, MultipartFile[] fileList, MemberVO user) {
		if(post == null ) {
			return false;
		}
		if(user == null) {
			return false;
		}
		
		//작성자인지 확인 
		if(!checkWriter(post.getPo_num(), user.getMe_id())) {
			return false;
		}
		
		boolean res;
		
		try {
			res = postDao.updatePost(post);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		if(!res) {
			return false;
		}
		
		//첨부파일 삭제
		if(fi_nums != null) {
			for(int fi_num : fi_nums) {
				deleteFile(fi_num);
			}
		}
		//첨부파일 추가
		if(fileList == null || fileList.length == 0) {
			return true;
		}
		for(MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		return true;
	}

	private boolean checkWriter(int po_num, String me_id) {
		PostVO post = postDao.selectPost(po_num);
		if(post == null) {
			return false;
		}
		return post.getPo_me_id().equals(me_id);
	}

	private void deleteFile(int fi_num) {
		//첨부파일 정보를 가져옴
		FileVO file = postDao.selectFile(fi_num);
		deleteFile(file);
	}
	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		//첨부파일을 서버에서 삭제
		UploadFileUtils.delteFile(uploadPath, file.getFi_name());
		//첨부파일 정보를 DB에서 삭제
		postDao.deleteFile(file.getFi_num());
	}

	public boolean deletePost(int po_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		if(!checkWriter(po_num, user.getMe_id())) {
			return false;
		}
		//서버에서 첨부파일 삭제
		List<FileVO> list = postDao.selectFileList(po_num);
		for(FileVO file : list) {
			deleteFile(file);
		}
		//DB에서 첨부파일 삭제(구현할 필요가 없음. 왜? 게시글 삭제 시 DB에서 해당 첨부파일을 삭제하기로 했기 때문)
		
		return postDao.deletePost(po_num);
	}

	public boolean insertCommunity(String name) {
		if(name == null || name.trim().length() == 0) {
			return false;
		}
		try {
			return postDao.insertCommunity(name);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCommunity(int co_num) {
		List<CommunityVO> list = postDao.selectCommunityList();
		if(list.size() == 1) {
			return false;
		}
		return postDao.deleteCommunity(co_num);
	}

	public boolean updateCommunity(CommunityVO community) {
		if(community == null) {
			return false;
		}
		try {
			return postDao.updateCommunity(community);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
