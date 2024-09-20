package kr.kh.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.kh.study.interceptor.MemberInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.kh.study") 
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
	// TilesViewResolver 설정
    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(1); // ViewResolver의 우선순위 설정
        return tilesViewResolver;
    }
    // Tiles 설정
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/spring/tiles.xml");
        tilesConfigurer.setCheckRefresh(true); // 변경 사항을 자동으로 감지하여 갱신
        return tilesConfigurer;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 인터셉터 추가 및 URL 패턴 설정
        registry.addInterceptor(new MemberInterceptor())
                .addPathPatterns("/post/**")  // 모든 경로에 대해 인터셉터 적용
                .excludePathPatterns("/post/list", "/post/detail"); //제외할 경로
    }
}