package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/delete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//게시글 번호를 가져옴
    	String po_num = request.getParameter("po_num");
    	//로그인한 회원 정보를 가져옴
    	MemberVO user = (MemberVO)request.getSession().getAttribute("user");
    	//게시글과 회원 정보를 이용해서 삭제
    	int co_num = postService.deletePost(po_num, user);
    	//삭제 여부에 따라 알림을 출력
		if(co_num != 0) {
			request.setAttribute("url", "/post/list?co_num="+co_num);
			request.setAttribute("msg", "게시글을 삭제했습니다.");
		}else {
			request.setAttribute("url", "/post/detail?po_num="+po_num);
			request.setAttribute("msg", "게시글을 삭제하지 못했습니다.");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}
}
