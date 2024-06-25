package day20.socket4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx04 {

	public static void main(String[] args) {
		int port = 5001;
		
		try(ServerSocket serverSocket = 
				new ServerSocket(port)){
			System.out.println("[대기 중]");
			Socket socket = serverSocket.accept();
			System.out.println("[연결 성공]");
			Client client = new Client(socket);
			client.send();
			client.recive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
