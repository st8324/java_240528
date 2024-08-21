package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/community")
public class Community extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//등록된 커뮤니티 목록을 가져와서 화면에 전달
    	List<CommunityVO> list = postService.getCommunityList();
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("/WEB-INF/views/post/community.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//등록된 커뮤니티 목록을 가져와서 화면에 전달
    	List<CommunityVO> list = postService.getCommunityList();
    	
    	JSONObject jobj = new JSONObject();
    	jobj.put("list", list);
    	
    	response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
