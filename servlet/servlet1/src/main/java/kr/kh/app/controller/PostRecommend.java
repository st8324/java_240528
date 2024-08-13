package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
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
    	
    	JSONObject jobj = new JSONObject();
    	ObjectMapper om = new ObjectMapper();
    	try {
    		int po_num = Integer.parseInt(num);
    		int re_state = Integer.parseInt(state);
    		String me_id = user.getMe_id();
    		RecommendVO recommend = new RecommendVO(po_num, re_state, me_id);
    		int res = postService.insertRecommend(recommend);
    		
    		PostVO post = postService.getPost(po_num);
    		String postStr = om.writeValueAsString(post);//post객체의 값들을 json형태의 문자열로 변환
    		jobj.put("result", res);
    		jobj.put("post", postStr);
    	}catch(Exception e) {
    		e.printStackTrace();
    		jobj.put("error", "Exception 발생");
    	}
    	response.setContentType("application/json; charset=utf-8");
    	response.getWriter().print(jobj);
	}

}
