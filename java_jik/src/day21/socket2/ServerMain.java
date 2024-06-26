package day21.socket2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {

	public static void main(String[] args) {
		int port = 5001;
		String fileName = "src/day21/socket2/server.txt";
		try {
			//1. ServerSocket 객체 생성
			ServerSocket serverSocket = new ServerSocket(port);
			//2. 무한루프
			while(true) {
				//3. 소켓 승인
				Socket socket = serverSocket.accept();
				
				//4. 소켓을 이용하여 ObjectInputStrea 객체 생성
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				//5. 소켓을 통해 문자열을 읽어옴
				String type = ois.readUTF();
				
				//6. 읽어온 문자열이 save이면 save메소드를 실행하여 저장
				switch(type) {
				case "save":
					save(fileName, ois);
					break;
				case "load":
					load(fileName, oos);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	@SuppressWarnings("unchecked")
	private static void load(String fileName, ObjectOutputStream oos) {
		//파일을 열어서 연락처 리스트를 가져옴
		List<Contact> list = new ArrayList<Contact>();
		try(ObjectInputStream fois = new ObjectInputStream(new FileInputStream(fileName))){
			list = (List<Contact>) fois.readObject();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//oos를 이용해서 연락처 리스트를 전송
		try {
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void save(String fileName, 
			ObjectInputStream ois) {
		List<Contact> list;
		//ois를 통해 연락처 리스트를 가져옴
		try {
			list = (List<Contact>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		//파일을 열어서 위에서 가져온 연락처 리스트를 저장
		try(ObjectOutputStream foos = new ObjectOutputStream(new FileOutputStream(fileName))){
			foos.writeObject(list);
			foos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
