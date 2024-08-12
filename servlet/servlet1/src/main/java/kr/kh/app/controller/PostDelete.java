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

@WebServlet("/post/delete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//게시글 번호를 가져옴
    	String po_num = request.getParameter("po_num");
    	//로그인한 회원 정보를 가져옴
    	MemberVO user = (MemberVO)request.getSession().getAttribute("user");
    	
    	//게시글 정보를 가져옴(왜? 카테고리 번호 때문에)
    	PostVO post = postService.getPost(Integer.parseInt(po_num));
    	
    	//서비스에게 게시글 번호와 회원 정보를 주면서 삭제하라고 요청
    	//성공하면 성공 알림
    	if(postService.deletePost(po_num, user)) {
    		request.setAttribute("msg", "게시글 삭제에 성공했습니다.");
    	}
    	//실패하면 실패 알림
    	else {
    		request.setAttribute("msg", "게시글 수정에 실패했습니다.");
    	}
    	request.setAttribute("url", "/post/list?co_num="+(post==null?"":post.getPo_co_num()));
    	request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}
}
