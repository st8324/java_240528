<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <form>
            <div>
	            <form action="">
				   	<input type="text" id="message" name="message">
            		<input type="button" value="Send" onclick="send()"><br>
				</form>
			</div>
			<div id="outputDiv"></div>
		</form>
    </body>
    <script type="text/javascript">
	    websocket = new WebSocket("ws://localhost:8080/spring3/echo.do");
		websocket.onopen = function(evt) {
	        writeToScreen("WebSocket 연결!");
	    };
	    websocket.onmessage = function(evt) {
	        onMessage(evt)
	    };
	    websocket.onerror = function(evt) {
	        onError(evt)
	    };
		
		
		// WebSocket 연결
		function send(evt) {
		    
		    doSend($("#message").val());
		}
		
		// 메시지 수신
		function onMessage(evt) {
		    writeToScreen("메시지 수신 : " + evt.data);
		}
		
		// 에러 발생
		function onError(evt) {
		    writeToScreen("에러 : " + evt.data);
		}
		
		function doSend(message) {
		    //writeToScreen("메시지 송신 : " + message);
		    websocket.send(message);
		}
		
		function writeToScreen(message) {
		    $("#outputDiv").append("<p>" + message + "</p>");
		}
	</script>
		    
</html>
