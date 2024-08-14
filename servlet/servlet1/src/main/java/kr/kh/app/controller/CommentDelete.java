package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comment/delete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보내준 댓글 번호를 가져옴
		String num = request.getParameter("co_num");
		JSONObject jobj = new JSONObject();
		try {
			int co_num = Integer.parseInt(num);
			//회원 정보를 가져옴
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			boolean res = postService.deleteComment(co_num, user);
			jobj.put("result", res);
		}catch(Exception e) {
			
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
