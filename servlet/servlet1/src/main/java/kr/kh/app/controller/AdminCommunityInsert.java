package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.service.AdminService;
import kr.kh.app.service.AdminServiceImp;

@WebServlet("/admin/community/insert")
public class AdminCommunityInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService adminService = new AdminServiceImp();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//커뮤니티 이름을 가져옴
		String co_name = request.getParameter("co_name");
		//서비스에게 등록하라고 시키고 결과를 화면에 전송
		if(adminService.insertCommunity(co_name)) {
			request.setAttribute("url", "/admin/community");
			request.setAttribute("msg", "커뮤니티 등록에 성공했습니다.");
		}else {
			request.setAttribute("url", "/admin/community");
			request.setAttribute("msg", "커뮤니티 등록에 실패했습니다.");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
