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
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.pagination.PostCriteria;
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
			//화면에서 보낸 페이지 번호를 가져옴
			String pageStr = request.getParameter("page");
			int page = 1;
			if(pageStr != null && pageStr.length() != 0) {
				page = Integer.parseInt(pageStr);
			}
			
			String type = request.getParameter("type");
			String search = request.getParameter("search");
			
			//서비스에게 커뮤니티 번호를 주면서 커뮤니티 정보를 가져오라고 시킴
			CommunityVO community = postService.getCommunity(coNum);
			//커뮤니티 정보가 없으면 예외를 발생시킴
			if(community == null) {
				throw new Exception();
			}
			Criteria cri = new PostCriteria(page, 2, search, coNum, type);
			PageMaker pm = postService.getPageMaker(cri, 2);
			//서비스에게 커뮤니티 번호를 주면서 게시글 리스트를 가져오라고 시킴
			List<PostVO> list = postService.getPostList(cri);
			
			//화면에 커뮤니티 정보를 전송
			request.setAttribute("co", community);
			//화면에 가져온 게시글 리스트를 전송 
			request.setAttribute("list", list);
			//화면에 페이지네이션 정보를 전송
			request.setAttribute("pm", pm);
			request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "잘못된 커뮤니티입니다.");
			request.setAttribute("url", "/community");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		
	}

}
