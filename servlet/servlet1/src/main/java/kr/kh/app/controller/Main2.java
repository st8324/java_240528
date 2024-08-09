package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.Person;

@WebServlet("/test")
public class Main2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		//화면에 홍길동이라는 이름을 전송
		//name : 화면(jsp)에서 사용할 변수명
		//홍길동 : 화면에 보낼 이름
		request.setAttribute("name", "홍길동");
		
		Person p = new Person("임꺽정", 20);
		request.setAttribute("person", p);
		
		String name = request.getParameter("name");
		System.out.println("화면에서 보낸 이름 : " + name);
		Integer age = null;
		try {
			age = Integer.parseInt(request.getParameter("age"));
			System.out.println("화면에서 보낸 나이 : " + age);
		}catch (Exception e) {
			System.out.println("화면에서 보낸 나이 : null");
		}
		List<MemberVO> list = new ArrayList<MemberVO>();
		list.add(new MemberVO("abc","abc123"));
		list.add(new MemberVO("asd","asd123"));
		list.add(new MemberVO("zxc","zxc123"));
		list.add(new MemberVO("qwe","qwe123"));
		request.setAttribute("list", list);
		//WEB-INF/views/main.jsp를 가져와서 화면에 전달
		request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
		
	}

}
