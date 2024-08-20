package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//아이디, 비번, 이메일을 가져옴
		String me_id = request.getParameter("me_id");
		String me_pw = request.getParameter("me_pw");
		String me_email = request.getParameter("me_email");
		
		MemberVO member = new MemberVO(me_id, me_pw, me_email);
		if(memberService.signup(member)) {
			request.setAttribute("msg", "회원 가입을 완료했습니다.");
			request.setAttribute("url", "/");
		}else {
			request.setAttribute("msg", "회원 가입을 완료하지 못했습니다.");
			request.setAttribute("url", "/signup");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
