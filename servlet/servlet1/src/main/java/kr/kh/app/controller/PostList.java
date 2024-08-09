package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/list")
public class PostList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int coNum = 0;
		
		try {
			//화면에서 보낸 커뮤니티번호를 가져옴
			coNum = Integer.parseInt(request.getParameter("co_num"));
			//서비스에게 커뮤니티 번호를 주면서 커뮤니티 정보를 가져오라고 시킴
			CommunityVO community = postService.getCommunity(coNum);
			//커뮤니티 정보가 없으면 예외를 발생시킴
			if(community == null) {
				throw new Exception();
			}
			//서비스에게 커뮤니티 번호를 주면서 게시글 리스트를 가져오라고 시킴
			List<PostVO> list = postService.getPostList(coNum);
			
			//화면에 커뮤니티 정보를 전송
			request.setAttribute("co", community);
			//화면에 가져온 게시글 리스트를 전송 
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
		}catch(Exception e) {
			request.setAttribute("msg", "잘못된 커뮤니티입니다.");
			request.setAttribute("url", "/community");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		
	}

}
