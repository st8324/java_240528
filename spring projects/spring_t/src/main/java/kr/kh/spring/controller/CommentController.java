package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.CommentService;

//@RestController //컨트롤러 안에 있는 메소드에 @ResponseBody를 붙이지 않아도 ajax로 통신
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@PostMapping("/insert")
	public boolean insert(@RequestBody CommentVO comment, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		return commentService.insertComment(comment, user);
	}
	
	@ResponseBody
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Criteria cri){
		cri.setPerPageNum(2);
		Map<String, Object> map = new HashMap<String, Object>();
		//댓글 리스트
		List<CommentVO> list = commentService.getCommentList(cri);
		//댓글 페이지메이커
		PageMaker pm = commentService.getCommentPageMaker(cri);
		map.put("list", list);
		map.put("pm", pm);
		return map;
	}
	
	@PostMapping("/list2")
	public String list2(Model model, @RequestBody Criteria cri){
		cri.setPerPageNum(2);

		//댓글 리스트
		List<CommentVO> list = commentService.getCommentList(cri);
		//댓글 페이지메이커
		PageMaker pm = commentService.getCommentPageMaker(cri);

		model.addAttribute("list",list);
		model.addAttribute("pm",pm);
		return "comment/pagination";
	}
}
