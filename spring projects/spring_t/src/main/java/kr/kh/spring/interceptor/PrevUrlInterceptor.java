package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

//관리자만 관리자 페이지에 접근할 수 있게 하기 위해서
public class PrevUrlInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		HttpSession session = request.getSession();
		//이전 URL을 가져옴
		String prevUrl = (String)session.getAttribute("prevUrl");

		//이전 URL이 없으면 종료
		if(prevUrl == null) {
			return;
		}
		//로그인한 회원 정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user");

		//로그인한 회원 정보가 없으면 종료
		if(user == null) {
			return;
		}
		//이전 URL로 리다이렉트 하고 이전 URL을 제거
		response.sendRedirect(prevUrl);
		session.removeAttribute("prevUrl");
	}
	
}
