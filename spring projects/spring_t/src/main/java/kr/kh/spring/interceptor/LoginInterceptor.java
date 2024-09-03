package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;


public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		
		//회원 정보를 가져옴
		MemberVO user = (MemberVO) modelAndView.getModel().get("user");
		//로그인에 실패한 경우 또는 로그인 페이지로 가는 경우
		if(user == null) {
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//자동 로그인이 아닌 경우
		if(!user.isAutoLogin()) {
			return;
		}
		//세션 아이디를 가져옴 => 쿠키의 value로 들어가기 위해서
		String sid = session.getId();
		//쿠키를 생성 LC
		Cookie cookie = new Cookie("LC", sid);
		//쿠키의 만료 시간을 계산(7일)
		int time = 60 * 60 * 24 * 7;//7일을 초로 계산
		cookie.setMaxAge(time);
		cookie.setPath("/");
		
		//회원 정보에 쿠키와 만료 시간을 수정
		
		
		//화면에 쿠키를 전송
		response.addCookie(cookie);
		
	}
	
}
