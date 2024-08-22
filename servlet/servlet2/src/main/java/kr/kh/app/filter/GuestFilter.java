package kr.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.vo.MemberVO;

@WebFilter({"/login", "/signup"})
public class GuestFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpSession session = hrequest.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(user != null) {
			request.setAttribute("msg", "로그인한 사용자는 이용할 수 없는 서비스입니다.");
			request.setAttribute("url", "/");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}
}
