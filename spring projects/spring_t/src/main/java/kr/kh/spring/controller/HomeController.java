package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	//private MemberService memberService = new MemberServiceImp();
	
	@Autowired
	private MemberService memberService;
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home(Model model,
		//화면에서 보낸 정보를 객체로 받는 경우 실행 과정
		//1. 해당 클래스의 기본 생성자가 호출 
		//2. 화면에서 보낸 name과 같은 멤버변수들의 setter를 호출해서 값을 변경
			PersonDTO person) {
		System.out.println(person);

		model.addAttribute("name", "홍길동");
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("msg", "회원 가입을 했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원 가입을 하지 못했습니다.");
			model.addAttribute("url", "/signup");
		}
		return "/main/message";
	}
}
