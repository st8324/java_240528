package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.AdminService;
import kr.kh.app.service.AdminServiceImp;

@WebServlet("/admin/community/delete")
public class AdminCommunityDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService adminService = new AdminServiceImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//커뮤니티 번호를 가져옴
		String num = request.getParameter("co_num");
		try {
			int co_num = Integer.parseInt(num);
			//회원정보를 가져옴
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			if(adminService.deleteCommunity(co_num, user)) {
				request.setAttribute("msg", "커뮤니티를 삭제했습니다.");
			}else {
				throw new RuntimeException();
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "커뮤니티를 삭제하지 못했습니다.");
		}
		request.setAttribute("url", "/admin/community");
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}
}
