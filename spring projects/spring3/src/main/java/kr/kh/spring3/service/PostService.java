package kr.kh.spring3.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.dao.PostDAO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.utils.UploadFileUtils;

@Service
public class PostService {

	@Autowired
	PostDAO postDao;
	
	@Resource
	String uploadPath;

	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return postDao.selectPostList(cri);
	}

	public PageMaker getPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount = postDao.selectPostTotalcount(cri);
		return new PageMaker(3, cri, totalCount);
	}

	public PostVO getPost(int po_num) {
		return postDao.selectPost(po_num);
	}

	public void updateView(int po_num) {
		postDao.updateView(po_num);
	}

	public List<FileVO> getFileList(int po_num) {
		return postDao.selectFileList(po_num);
	}

	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		if(post == null || user == null) {
			return false;
		}
		if(post.getPo_title().length() == 0) {
			return false;
		}
		
		post.setPo_me_id(user.getMe_id());
		
		
		boolean res = postDao.insertPost(post);
		
		if(!res) {
			return false;
		}
		
		uploadFileList(fileList, post.getPo_num());
		
		return true;
	}

	private void uploadFile(MultipartFile file, int po_num) {
		if(file == null || file.getOriginalFilename().length() == 0) {
			return;
		}
		
		//첨부파일을 서버에 업로드
		String fi_ori_name = file.getOriginalFilename();
		try {
			String fi_name = 
				UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());

			//업로드한 정보를 DB에 추가
			FileVO fileVo = new FileVO(fi_name, fi_ori_name, po_num);
			postDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void uploadFileList(MultipartFile [] fileList, int po_num) {
		if(fileList == null || fileList.length == 0) {
			return;
		}
		for(MultipartFile file : fileList) {
			uploadFile(file, po_num);
		}
	}
	
	public boolean updatePost(PostVO post, MemberVO user, MultipartFile[] fileList, int[] nums) {
		if(post == null) {
			return false;
		}
		//작성자 체크
		if(!isWriter(post.getPo_num(), user)) {
			return false;
		}
		
		boolean res = postDao.updatePost(post);
		
		if(!res) {
			return false;
		}
		//첨부파일 수정
		//새 첨부파일들 추가
		uploadFileList(fileList, post.getPo_num());
		//기존 첨부파일 삭제
		if(nums == null || nums.length == 0) {
			return true;
		}
		for(int fi_num : nums) {
			FileVO file = postDao.selectFile(fi_num);
			deleteFile(file);
		}
		return true;
	}

	private boolean isWriter(int po_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		PostVO post = postDao.selectPost(po_num);
		if(post != null && post.getPo_me_id().equals(user.getMe_id())) {
			return true;
		}
		return false;
	}

	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		UploadFileUtils.delteFile(uploadPath, file.getFi_name());
		postDao.deleteFile(file.getFi_num());
	}

	public boolean deletePost(int po_num, MemberVO user) {
		//작성자 체크
		if(!isWriter(po_num, user)) {
			return false;
		}
		//첨부파일 삭제
		List<FileVO> list = postDao.selectFileList(po_num);
		for(FileVO file : list) {
			deleteFile(file);
		}
		//게시글 삭제
		return postDao.deletePost(po_num);
	}
}
