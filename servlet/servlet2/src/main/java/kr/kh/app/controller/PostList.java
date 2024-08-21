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
		//1. 커뮤니티 정보를 가져와서 화면에 전달
		//커뮤니티 번호를 가져옴
		String num = request.getParameter("co_num");
		//커뮤니티 번호를 이용해서 커뮤니티 정보를 가져옴
		CommunityVO community = postService.getCommunity(num);
		
		//3. 현재 페이지 정보를 이용해서 게시글 목록을 가져옴
		//페이지번호를 가져옴
		String page = request.getParameter("page");
		//검색어를 가져옴
		String search = request.getParameter("search");
		//타입을 가져옴
		String type = request.getParameter("type");
		//페이지번호, 검색어, 타입을 이용해서 Critera 객체를 생성
		Criteria cri = new PostCriteria(num, page, search, type, 5);
		//서비스에게 객체를 주면서 게시글 목록을 가져오라고 요청
		List<PostVO> list = postService.getPostList(cri);
		
		//4. 현재 페이지 정보를 이용해서 페이지네이션을 가져옴 
		PageMaker pm = postService.getPostPageMaker(cri);
		//1,3,4번에서 가져온 정보를 화면에 전송
		request.setAttribute("co", community);
		request.setAttribute("list", list);
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
	}
}
