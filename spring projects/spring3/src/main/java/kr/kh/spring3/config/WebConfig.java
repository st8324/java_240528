package kr.kh.spring3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.kh.spring3.interceptor.LoginInterceptor;
import lombok.extern.log4j.Log4j;

@Configuration
@Log4j
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("설정");
        registry.addInterceptor(loginInterceptor)
	                .addPathPatterns("/guest/login");
    }

}