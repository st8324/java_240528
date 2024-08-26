package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	//private MemberService memberService = new MemberServiceImp();
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,
		//화면에서 보낸 정보를 객체로 받는 경우 실행 과정
		//1. 해당 클래스의 기본 생성자가 호출 
		//2. 화면에서 보낸 name과 같은 멤버변수들의 setter를 호출해서 값을 변경
			PersonDTO person) {
		System.out.println(person);

		model.addAttribute("name", "홍길동");
		return "home";
	}
	
}
