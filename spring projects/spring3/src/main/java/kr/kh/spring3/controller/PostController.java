package kr.kh.spring3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.pagination.PostCriteria;
import kr.kh.spring3.service.PostService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/list/{co_num}")
	public String list(Model model, @PathVariable("co_num")int co_num, PostCriteria cri) {
		cri.setCo_num(co_num);
		cri.setPerPageNum(3);
		//커뮤니티 목록을 가져옴
		List<CommunityVO> communities = postService.getCommunityList();
		
		//게시글 목록을 가져옴(전체)
		List<PostVO> list = postService.getPostList(cri);
		
		//페이지메이커 
		PageMaker pm = postService.getPageMaker(cri);
		
		model.addAttribute("communities", communities);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		log.info("/post/list:get");
		return "/post/list";
	}
	@GetMapping("/detail/{po_num}")
	public String detail(Model model, @PathVariable("po_num") int po_num) {
		log.info("/post/detail:get");
		//조회수 증가
		postService.updateView(po_num);
		//게시글 가져옴
		PostVO post = postService.getPost(po_num);
		//첨부파일 가져옴
		List<FileVO> fileList = postService.getFileList(po_num);
		
		//화면에 전달
		model.addAttribute("post", post);
		model.addAttribute("list", fileList);
		return "/post/detail";
	}
}
