package db.community.controller;

import java.util.Scanner;

import db.community.model.vo.MemberVO;
import db.community.service.MemberService;
import db.community.service.MemberServiceImp;

public class MemberController {

	private MemberService memberService = new MemberServiceImp();
	private Scanner scan;
	
	public MemberController(Scanner scan) {
		this.scan = scan;
	}

	public MemberVO login() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();

		//비번 입력
		System.out.print("비번 : ");
		String pw = scan.next();
		
		//서비스에게 아이디, 비번을 주면서 일치하는 회원 정보를 가져오라고 시킴
		MemberVO user = memberService.login(id, pw);
		
		//가져온 회원 정보를 반환
		return user;
	}

	public boolean signup() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();
		//비번 입력
		System.out.print("비번 : ");
		String pw = scan.next();
		//비번 확인 입력
		System.out.print("비번 확인 : ");
		String pw2 = scan.next();
		//이메일 입력
		System.out.print("이메일 : ");
		String email = scan.next();
		
		//비번과 비번확인이 다르면 false를 리턴
		if(!pw.equals(pw2)) {
			return false;
		}
		
		return memberService.signup(id, pw, email);
	}
	
	
}
