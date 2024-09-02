package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/community")
	public String community(Model model) {
		List<CommunityVO> list = postService.getCommunityList();
		model.addAttribute("list", list);
		return "/admin/community";
	}
	@PostMapping("/community/insert")
	public String communityInsert(Model model, String name) {
		boolean res = postService.insertCommunity(name);
		if(res) {
			model.addAttribute("msg", "커뮤니티를 등록했습니다.");
		}else {
			model.addAttribute("msg", "커뮤니티를 등록하지 못했습니다.");
		}
		model.addAttribute("url", "/admin/community");
		return "/main/message";
	}
}
