package kr.kh.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;

@RestController//@Controller + @ResposeBody
@RequestMapping("/test")
public class TestController {

	@Autowired
	MemberService memberService;
	
	@PostMapping("/signup")
	public boolean signup(@RequestBody MemberVO member) {
		System.out.println(member);
		return memberService.signup(member);
	}
}
