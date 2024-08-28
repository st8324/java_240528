package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;
import kr.kh.spring.service.PostService;

//게시글과 관련된 URL을 처리하는 컨트롤러.
//URL 시작이 /post로 시작
@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/list")
	public String list(Model model, PostCriteria cri) {
		//커뮤니티 리스트를 가져옴
		List<CommunityVO> list = postService.getCommunityList();
		//현재 페이지 정보를 주면서 게시글 리스트를 가져오라고 시킴
		cri.setPerPageNum(2);
		List<PostVO> postList = postService.getPostList(cri);
		
		//현제 페이지 정보를 주면서 페이지네이션 정보를 가져오라고 시킴
		PageMaker pm = postService.getPageMaker(cri);
		//화면에 전송
		model.addAttribute("list", list);
		model.addAttribute("postList", postList);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
}
