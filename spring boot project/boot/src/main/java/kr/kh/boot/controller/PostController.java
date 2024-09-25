package kr.kh.boot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.service.PostService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostController {

	private PostService postService;
	
	@GetMapping("/post/list/{co_num}")
	public String postList(Model model, @PathVariable int co_num) {
		//커뮤니티 번호에 맞는 게시글 목록을 가져와서 화면에 전달
		List<PostVO> list = postService.getPostList(co_num);
		//커뮤니티 목록을 가져와서 화면에 전달
		List<CommunityVO> communities = postService.getCommunityList();
		model.addAttribute("list", list);
		model.addAttribute("communities", communities);
		return "post/list";
	}
}
