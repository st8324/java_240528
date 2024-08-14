package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comment/insert")
public class CommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 번호, 댓글 내용, 댓글 원래 번호
		String po_num = request.getParameter("cm_po_num");
		String cm_content = request.getParameter("cm_content");
		String ori_num = request.getParameter("cm_ori_num");
		JSONObject jobj = new JSONObject();
		try {
			int cm_po_num = Integer.parseInt(po_num);
			int cm_ori_num = Integer.parseInt(ori_num);
			
			//회원 정보 가져옴
			//MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			//String cm_me_id = user.getMe_id();
			String cm_me_id = "abc123";
			
			CommentVO comment = new CommentVO(cm_po_num, cm_ori_num, cm_content, cm_me_id);
			boolean res = postService.insertComment(comment);
			jobj.put("result", res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
