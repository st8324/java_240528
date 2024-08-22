package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/post/detail")
public class PostDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PostService postService = new PostServiceImp();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//게시글 정보를 가져와서 화면에 전달
    	//1. 게시글 번호를 가져옴
    	String po_num = request.getParameter("po_num");
    	//게시글 조회수를 증가
    	postService.updatePostView(po_num);
    	//2. 게시글 번호를 이용해서 게시글 정보를 가져옴
    	PostVO post = postService.getPost(po_num);
    	//3. 게시글 정보를 화면에 전달
    	request.setAttribute("post", post);
    	request.getRequestDispatcher("/WEB-INF/views/post/detail.jsp").forward(request, response);
	}
}
