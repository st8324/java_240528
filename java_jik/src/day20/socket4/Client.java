package day20.socket4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

//연결 소켓을 이용하여 데이터를 주고 받는(Scanner를 통해) 클래스
@AllArgsConstructor
public class Client {
	
	private Socket socket;
	public final static String EXIT = "-1";
	//소켓에서 보내온 문자열을 받아서 출력하는 쓰레드를 생성하고 실행하는 메소드
	public void recive() {
		Thread t= new Thread(()->{
			
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				while(true) {
					String chat = ois.readUTF();
					if(chat.equals(EXIT)) {
						break;
					}
					System.out.println("내용 : " + chat);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	
	//문자열을 입력해서 소켓으로 전송하는 쓰레드를 생성하고 실행하는 메소드
	public void send() {
		Thread t = new Thread(()->{
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				Scanner scan = new Scanner(System.in);
				while(true) {
					String str = scan.nextLine();
					oos.writeUTF(str);
					oos.flush();
					if(str.equals(EXIT)) {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
}
