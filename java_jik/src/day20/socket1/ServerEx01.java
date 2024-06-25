package day20.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ServerEx01 {

	//클라이언트가 연결되면 클라이언트에서 보낸 값을 입력받고 서버에서 클라이언트에게 값을 전송하고
	//종료하는 프로그램
	public static void main(String[] args) {
		//1. 포트 번호를 설정
		int port = 5001;
		//전송할 데이터
		List<String> list = Arrays.asList("홍길동", "임꺽정", "둘리", "고길동", "-1");

		try {
			//2. 서버용 소켓 객체 생성
			ServerSocket serverSocket = new ServerSocket(port);
			
			System.out.println("[대기 중].....");
			
			//3.대기
			//4. 요청 수락 후 소켓 객체를 생성
			Socket socket = serverSocket.accept();
			System.out.println("[연결 성공].....");
			//클라이언트에서 보낸 문자열들을 읽어 옴
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			while(true) {
				String str = ois.readUTF();
				//클라이언트에서 보낸 문자열이 -1이면 읽기 종료
				if(str.equals("-1")) {
					break;
				}
				System.out.println("클라이언트에서 보낸 문자열 : " + str);
			}
			System.out.println("[수신 성공]");
			//서버에서 클라이언트로 문자열들을 전송
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			for(String tmp : list) {
				oos.writeUTF(tmp);
			}
			oos.flush();
			
			System.out.println("[전송 성공]");
			
			ois.close();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
