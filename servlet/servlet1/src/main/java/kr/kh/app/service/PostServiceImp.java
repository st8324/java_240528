package kr.kh.app.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.utils.FileUploadUtils;

public class PostServiceImp implements PostService {

	private PostDAO postDao;
	
	private String uploadPath = "D:\\uploads";
	
	public PostServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {

			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	@Override
	public CommunityVO getCommunity(int coNum) {
		return postDao.selectCommunity(coNum);
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			throw new RuntimeException();
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		if(cri == null) {
			throw new RuntimeException();
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(totalCount, displayPageNum, cri);
	}

	@Override
	public boolean insertPost(PostVO post, ArrayList<Part> files) {
		if(post == null) {
			return false;
		}
		if(post.getPo_title() == null || post.getPo_title().trim().length() == 0) {
			return false;
		}
		if(post.getPo_content() == null || post.getPo_content().trim().length() == 0) {
			return false;
		}
		boolean res =  postDao.insertPost(post);
		//게시글이 등록되지 않으면 첨부파일을 추가하지 않음
		if(!res) {
			return false;
		}
		if(files == null || files.size() == 0) {
			return true;
		}

		//첨부파일을 추가
		for(Part file : files) {
			if("fileList".equals(file.getName())) {
				uploadFile(post.getPo_num(), file);
			}
		}
		return true;
	}

	private void uploadFile(int po_num, Part file) {
		if(file == null) {
			return;
		}
		
		String fileName = FileUploadUtils.getFileName(file);
		if(fileName == null || fileName.trim().length() == 0) {
			return;
		}
		//첨부파일을 업로드 하고 업로드된 경로와 파일명을 가져옴
		String uploadFileName = FileUploadUtils.upload(uploadPath, file);
		FileVO fileVO = new FileVO(po_num, fileName, uploadFileName);
		postDao.insertFile(fileVO);
	}

	@Override
	public PostVO getPost(int num) {
		return postDao.selectPost(num);
	}

	@Override
	public void updatePostView(int num) {
		postDao.updatePostView(num);
	}

	@Override
	public PostVO getPost(int po_num, MemberVO user) {
		//회원이 null이면 null을 반환
		if(user == null) {
			return null;
		}
		//게시글 번호에 맞는 게시글을 가져옴
		PostVO post = postDao.selectPost(po_num);
		//게시글이 null이면 null을 반환
		if(post == null) {
			return null;
		}
		//게시글의 작성와 회원 아이디가 같으면 게시글을 반환
		if(checkWriter(po_num, user)) {
			return post;
		}
		//아니면 null을 반환
		return null;
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user, List<Part> fileList, String[] numStr) {
		if(post == null || user == null) {
			return false;
		}
		if(!checkWriter(post.getPo_num(), user)) {
			return false;
		}
		if(post.getPo_title() == null || post.getPo_title().trim().length() == 0) {
			return false;
		}
		if(post.getPo_content() == null || post.getPo_content().trim().length() == 0) {
			return false;
		}
		boolean res = postDao.updatePost(post);
		
		if(!res) {
			return false;
		}
		
		//새 첨부파일 추가
		for(Part file : fileList) {
			if("fileList".equals(file.getName())) {
				uploadFile(post.getPo_num(), file);
			}
		}
		
		//기존 첨부파일 삭제
		for(String num : numStr) {
			try {
				int fi_num = Integer.parseInt(num);
				deleteFile(fi_num);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	private void deleteFile(int fi_num) {
		
		//첨부파일 정보를 가져옴
		FileVO file = postDao.selectFile(fi_num);
		//서버에서 삭제
		deleteFile(file);
		//DB에서 삭제
		postDao.deleteFile(fi_num);
	}

	//게시글 작성자인지 아닌지 확인하는 메소드
	private boolean checkWriter(int po_num, MemberVO user) {
		//회원이 null이면 false을 반환
		if(user == null) {
			return false;
		}
		//게시글 번호에 맞는 게시글을 가져옴
		PostVO post = postDao.selectPost(po_num);
		//게시글이 null이면 false을 반환
		if(post == null) {
			return false;
		}
		//게시글의 작성와 회원 아이디가 같으면 true을 반환
		if(post.getPo_me_id().equals(user.getMe_id())) {
			return true;
		}
		//아니면 null을 반환
		return false;
	}

	@Override
	public boolean deletePost(String po_num, MemberVO user) {
		try {
			int poNum = Integer.parseInt(po_num);
			if(!checkWriter(poNum, user)) {
				return false;
			}
			
			//게시글 삭제 전 첨부파일 삭제
			List<FileVO> fileList = postDao.selectFileList(poNum);
			
			for(FileVO file : fileList) {
				deleteFile(file);
			}
			
			//게시글 삭제
			return postDao.deletePost(poNum);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		File realFile = new File(uploadPath + file.getFi_name().replace('/', File.separatorChar));
		
		if(realFile.exists()) {
			realFile.delete();
		}
		
	}

	@Override
	public int insertRecommend(RecommendVO recommend) {
		if(recommend == null) {
			throw new RuntimeException();
		}
		//기존에 추천 내용을 확인
		RecommendVO dbRecommend = postDao.selectRecommend(recommend);
		
		//없으면 추가 후 추천상태를 리턴
		if(dbRecommend == null){
			postDao.insertRecommend(recommend);
			return recommend.getRe_state();
		}
		//있으면 삭제 
		postDao.deleteRecommend(dbRecommend.getRe_num());
		
		//기존 상태와 새 상태가 같으면(취소)
		if(dbRecommend.getRe_state() == recommend.getRe_state()) {
			return 0;
		}
		//기존상태와 새 상태가 다르면(변경)
		postDao.insertRecommend(recommend);
		return recommend.getRe_state();
	}

	@Override
	public RecommendVO getRecommend(int num, MemberVO user) {
		if(user == null) {
			return null;
		}
		RecommendVO recommend = new RecommendVO(num, 0, user.getMe_id());
		return postDao.selectRecommend(recommend);
	}

	@Override
	public List<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return postDao.selectCommentList(cri);
	}

	@Override
	public PageMaker getCommentPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount = postDao.selectCommentTotalCount(cri);
		return new PageMaker(totalCount, 2, cri);
	}

	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null) {
			return false;
		}
		if(comment.getCm_content()== null || comment.getCm_content().trim().length() == 0) {
			return false;
		}
		return postDao.insertComment(comment);
	}

	@Override
	public boolean deleteComment(int co_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//작성자가 맞는지 확인
		CommentVO comment = postDao.selectComment(co_num);
		if(comment == null) {
			return false;
		}
		if(!comment.getCm_me_id().equals(user.getMe_id())) {
			return false;
		}
		//맞으면 삭제 요청
		return postDao.deleteComment(co_num);
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(user == null || comment == null) {
			return false;
		}
		//작성자가 맞는지 확인
		CommentVO dbComment = postDao.selectComment(comment.getCm_num());
		if(dbComment == null) {
			return false;
		}
		if(!dbComment.getCm_me_id().equals(user.getMe_id())) {
			return false;
		}
		//맞으면 삭제 요청
		return postDao.updateComment(comment);
	}

	@Override
	public List<FileVO> getFileList(int num) {
		
		return postDao.selectFileList(num);
	}

}
