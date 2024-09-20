package kr.kh.study.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {  }; // 여기에 다른 전역 설정 클래스를 지정합니다
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class }; // Spring MVC 설정 클래스
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // DispatcherServlet의 매핑 경로
    }
    

	// 필터 설정 추가
	@Override
	protected Filter[] getServletFilters() {
	    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	    encodingFilter.setEncoding("UTF-8");
	    encodingFilter.setForceEncoding(true); // 요청과 응답 모두 UTF-8로 강제 설정
	
	    return new Filter[] { encodingFilter };
	}
}
