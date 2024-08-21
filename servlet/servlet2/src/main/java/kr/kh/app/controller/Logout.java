package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 있는 회원 정보를 지움
		request.getSession().removeAttribute("user");
		//알림
		request.setAttribute("msg", "로그아웃을 했습니다.");
		request.setAttribute("url", "/");
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}


}
