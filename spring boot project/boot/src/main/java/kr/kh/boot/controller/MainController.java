package kr.kh.boot.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {
	

	@GetMapping("/")
	public String home(Model model, Principal p) {
		model.addAttribute("p", p);
		return "home";
	}
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
}
