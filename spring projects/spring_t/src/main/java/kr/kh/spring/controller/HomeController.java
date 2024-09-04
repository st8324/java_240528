package kr.kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
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
		log.info(person);

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
	
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		String prevUrl = request.getHeader("Referer");
		if(prevUrl != null && !prevUrl.contains("/login")) {
			request.getSession().setAttribute("prevUrl", prevUrl);
		}
		return "/member/login";
	}
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member, HttpSession session) {
		MemberVO user = memberService.login(member);
		if(user != null) {
			user.setAutoLogin(member.isAutoLogin());
			model.addAttribute("msg", "로그인을 성공 했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "로그인을 실패 했습니다.");
			model.addAttribute("url", "/login");
		}
		
		
		
		model.addAttribute("user", user);
		return "/main/message";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			user.setMe_cookie(null);
			memberService.updateMemberCookie(user);
		}
		//세션에 있는 user를 제거
		session.removeAttribute("user");
		model.addAttribute("msg", "로그아웃 했습니다.");
		model.addAttribute("url", "/");
		return "/main/message";
	}
	
	//@CrossOrigin(origins = "*")//모든 사이트들이 해당 URL에 데이터를 요청하도록 허용
	@ResponseBody
	@GetMapping("/check/id")
	public boolean checkId(@RequestParam("id")String id) {
		boolean res = memberService.checkId(id);
		return res;
	}
	@GetMapping("/find/pw")
	public String findPw() {
		return "/member/findPw";
	}
	@ResponseBody
	@PostMapping("/find/pw")
	public boolean findPwPost(@RequestParam String id) {
		boolean res = memberService.findPw(id);
		return res;
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "/member/mypage";
	}
	
	@PostMapping("/mypage")
	public String mypagePost(Model model, HttpSession session, MemberVO member) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = memberService.updateMember(user, member);
		if(res) {
			model.addAttribute("msg","회원 정보를 수정했습니다.");
		}else {
			model.addAttribute("msg","회원 정보를 수정했습니다.");
		}
		model.addAttribute("url","/mypage");
		return "/main/message";
	}
}
