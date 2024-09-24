package kr.kh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		return "home";
	}
	@GetMapping("/home2")
	public String home2(Model model) {
		return "home2";
	}
}
