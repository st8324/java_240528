package kr.kh.spring3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring3.model.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		
		HttpSession session = request.getSession();

		//회원 정보를 가져옴
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		log.info(user);
		//회원 정보가 없으면 종료
		if(user == null) {
			return;
		}
		//있으면 세션에 저장
		session.setAttribute("user", user);
	}
}
