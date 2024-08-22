package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/insert")
public class PostInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private PostService postService = new PostServiceImp(); 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//커뮤니티 번호를 가져와서 화면에 전달
		String co_num = request.getParameter("co_num");
		request.setAttribute("co_num", co_num);
		request.getRequestDispatcher("/WEB-INF/views/post/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 게시글 정보를 가져와서 게시글을 등록
		//1. 제목, 내용, 커뮤니티 번호를 가져옴
		String title = request.getParameter("po_title");
		String content = request.getParameter("po_content");
		String co_num = request.getParameter("po_co_num");
		//2. 로그인한 회원 정보를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//3. 제목, 내용, 커뮤니티, 회원 아이디를 이용해서 게시글객체를 생성
		PostVO post = new PostVO(co_num, title, content, user.getMe_id());
		//4. 게시글 객체를 등록 시킴
		boolean res = postService.insertPost(post);
		//등록 여부에 맞게 알림처리
		if(res) {
			request.setAttribute("msg", "게시글을 등록했습니다.");
			request.setAttribute("url", "/post/list?co_num="+co_num);
		}else {
			request.setAttribute("msg", "게시글을 등록하지 못했습니다.");
			request.setAttribute("url", "/post/insert?co_num="+co_num);
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
