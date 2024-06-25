package day20.socket3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx03 {

	public static void main(String[] args) {
		//서버 포트 설정
		int port = 5001;
		
		try {
			//서버용 소켓 객체 생성
			ServerSocket serverSocket = new ServerSocket(port);
			
			//대기 및 연결 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			
			System.out.println("클라이언트 연결 성공!");
			
			//클라이언트가 보낸 문자열을 읽어와서 콘솔에 출력하는 쓰레드
			Thread receiveThread = new Thread(()->{
				try {
					InputStream is = socket.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					while(true) {
						String chat = ois.readUTF();
						if(chat.equals("-1")) {
							System.out.println("클라이언트가 전송을 중단했습니다.");
							break;
						}
						System.out.println("내용 : " + chat);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			});
			receiveThread.start();
			
			//서버에서 콘솔창에 입력한 값을 클라이언트에 전송하는 쓰레드
			Thread sendThread = new Thread(()->{
				try {
					OutputStream os = socket.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(os);
					
					Scanner scan = new Scanner(System.in);
					while(true) {
						String str = scan.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if(str.equals("-1")) {
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("[서버 전송 기능 종료]");
			});
			sendThread.start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외 발생!!");
		}

	}
}
