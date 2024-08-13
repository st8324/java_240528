package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/post/recommend")
public class PostRecommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String state = request.getParameter("state");
    	String num = request.getParameter("num");
    	MemberVO user = (MemberVO)request.getSession().getAttribute("user");
    	
    	try {
    		int po_num = Integer.parseInt(num);
    		int re_state = Integer.parseInt(state);
    		String me_id = user.getMe_id();
    		RecommendVO recommend = new RecommendVO(po_num, re_state, me_id);
    		int res = postService.insertRecommend(recommend);
    		//추천했으면
    		if(res == 1) {
    			request.setAttribute("msg", "추천했습니다.");
    		}
    		//비추천했으면
    		else if(res == -1) {
    			request.setAttribute("msg", "비추천했습니다.");
    		}
    		//추천을 취소했으면
    		else if(re_state == 1) {
    			request.setAttribute("msg", "추천을 취소 했습니다.");
    		}
    		//비추천을 취소했으면
    		else {
    			request.setAttribute("msg", "비추천을 취소 했습니다.");
    		}
    	}catch(Exception e) {
    		request.setAttribute("msg", "추천을 하지 못했습니다.");
    		e.printStackTrace();
    	}
    	
    	
    	request.setAttribute("url", "/post/detail?num="+num);
    	request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
