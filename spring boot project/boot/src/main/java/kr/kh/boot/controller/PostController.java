package kr.kh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.boot.service.PostService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostController {

	private PostService postService;
	
	@GetMapping("/post/list/{co_num}")
	public String postList(@PathVariable int co_num) {
		
		System.out.println(co_num);
		return "post/list";
	}
}
