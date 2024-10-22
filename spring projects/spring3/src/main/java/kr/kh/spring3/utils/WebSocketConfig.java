package kr.kh.spring3.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSocket
@Log4j
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	log.info("웹소켓 등록");
        registry.addHandler(new SocketHandler(), "/echo.do").setAllowedOrigins("*");
    }

}
