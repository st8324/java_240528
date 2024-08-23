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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.vo.MemberVO;

@WebFilter("/*")
public class RedirectFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpSession session = hrequest.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		String prevUrl = (String)session.getAttribute("prevUrl");
		//로그인 했고, 이전 URL이 있으면
		if(user != null && prevUrl != null) {
			//이전 URL로 이동
			((HttpServletResponse)response).sendRedirect(prevUrl);
			//이전 URL을 제거
			session.removeAttribute("prevUrl");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
