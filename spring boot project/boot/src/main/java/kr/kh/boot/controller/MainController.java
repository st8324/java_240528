package kr.kh.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.boot.dao.PostDAO;

@Controller
public class MainController {
	
	@Autowired
	PostDAO postDao;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		System.out.println(postDao.count());
		return "home";
	}
	@GetMapping("/home2")
	public String home2(Model model) {
		return "home2";
	}
}
