package kr.kh.boot.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.boot.model.util.CustomUser;

@Controller
public class MainController {
	

	@GetMapping("/")
	public String home(Model model,
			@AuthenticationPrincipal CustomUser userDatails) {
		if(userDatails != null)
			System.out.println(userDatails.getMember().getMe_pw());
		model.addAttribute("name", "홍길동");
		return "home";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
