package kr.kh.spring3.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class SocketHandler extends TextWebSocketHandler implements InitializingBean {
	
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public SocketHandler() {
		super();
		log.info("소켓 핸들러 생성!");
	}
	
	// WebSocket 연결이 열리고 사용이 준비될 때 호출
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		sessionSet.add(session);
		log.info("세션 추가!");
	}
	
	// WebSocket 연결이 닫혔을 때 호출
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		sessionSet.remove(session);
		log.info("세션 제거!");
	}
	
	// 클라이언트로부터 메시지가 도착했을 때 호출
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		log.info("메시지 수신 : " + (String)message.getPayload());
		sendMessage((String)message.getPayload());
	}
	
	// 전송 에러 발생할 때 호출
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.error("웹소켓 에러!", exception);
	}
	
	// WebSocketHandler가 부분 메시지를 처리할 때 호출
	@Override
	public boolean supportsPartialMessages() {
		log.info("메소드 호출!");
		
		return super.supportsPartialMessages();
	}
	
	public void sendMessage(String message) {
		for(WebSocketSession session: this.sessionSet) {
			if(session.isOpen()) {
				try{
					session.sendMessage(new TextMessage(message));
					log.info("메시지 전송");
				} catch(Exception ignored) {
					log.error("메시지전송 실패!", ignored);
				}
			}
		}
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Thread thread = new Thread() {
			int i = 0;
			@Override
			public void run() {
				while(true) {
					try {
						sendMessage("실시간 서버 송신 메시지 : " + i++);
						Thread.sleep(1000);
					} catch(InterruptedException e) {
						e.printStackTrace();
						break;
					}
				}
			}
		};
		
		thread.start();
	}
}
