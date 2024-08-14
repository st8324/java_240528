package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/comment/update")
public class CommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//화면에서 보내준 댓글 번호를 가져옴
		String num = request.getParameter("cm_num");
		String cm_content = request.getParameter("cm_content");
		JSONObject jobj = new JSONObject();
		try {
			int cm_num = Integer.parseInt(num);
			//회원 정보를 가져옴
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			CommentVO comment = new CommentVO(cm_num, cm_content);
			
			boolean res = postService.updateComment(comment, user);
			jobj.put("result", res);
		}catch(Exception e) {
			
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
		
	}

}
