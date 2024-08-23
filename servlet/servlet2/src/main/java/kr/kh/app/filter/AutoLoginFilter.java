package kr.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;


@WebFilter("/*")
public class AutoLoginFilter extends HttpFilter implements Filter {
       
	private MemberService memberService = new MemberServiceImp();
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//세션에 저장된 회원 정보를 가져옴
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpSession session = hrequest.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(user != null) {
			chain.doFilter(request, response);
			return;
		}
		
		//로그인이 안됐을 때(null일때)
		
		//쿠키 정보를 가져옴(AL)
		Cookie cookie = getCookie(hrequest, "AL");
		
		if(cookie == null) {
			chain.doFilter(request, response);
			return;
		}
		
		//쿠키 정보가 있으면 
	
		//쿠키에 있는 세션값을 가져옴
		String sid = cookie.getValue();
		//서비스에게 세션값을 주면서 일치하는 회원 정보를 달라고 요청
		user = memberService.getMemberBySid(sid);
		//회원 정보를 가져오면
		if(user != null) {
			//세션에 저장
			session.setAttribute("user", user);
		}
		chain.doFilter(request, response);
		
	}

	private Cookie getCookie(HttpServletRequest hrequest, String name) {
		Cookie [] cookies = hrequest.getCookies();
		if(cookies == null || cookies.length == 0) {
			return null;
		}
		for(Cookie cookie : cookies) {
			if(name.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}

	
}
