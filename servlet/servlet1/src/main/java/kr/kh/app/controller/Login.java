package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 아이디와 비번을 가져옴
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//가져온 아이디와 비번을 이용하여 LoginDTO 클래스의 객체를 생성
		LoginDTO member = new LoginDTO(id, pw, "");
		
		//LoginDTO객체를 서비스에게 주면서 일치하는 회원 정보를 가져오라고 요청
		MemberVO user = memberService.login(member);
		
		//가져온 회원정보가 null이면 msg에 로그인 실패!, url은 /login을 화면에 전송. 화면은 message.jsp
		if(user == null) {
			request.setAttribute("msg", "로그인 실패!");
			request.setAttribute("url", "/login");
		}
		//null이 아니면 msg에 로그인 성공!, url은 /을 화면에 전송. 화면은 message.jsp
		else {
			request.setAttribute("msg", "로그인 성공!");
			request.setAttribute("url", "/");
			//세션에 회원 정보를 저장
			request.getSession().setAttribute("user", user);
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
