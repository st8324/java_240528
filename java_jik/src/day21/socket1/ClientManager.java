package day21.socket1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day18.homework.v1.Schedule;
import program.Program;

//속담을 관리하는 프로그램
public class ClientManager implements Program{
	
	private Scanner scan = new Scanner(System.in);
	
	private String fileName ="src/day21/socket1/client.txt";
	
	private List<String> list = new ArrayList<String>();
	
	private String ip = "192.168.30.199";
	
	private int port = 5001;
	
	@Override
	public void printMenu() {
		System.out.print(
				  "메뉴\n"
				+ "1. 속담 추가\n"
				+ "2. 속담 삭제\n"
				+ "3. 종료\n"
				+ "메뉴선택 : ");
		
	}

	@Override
	public void run() { 
		int menu = 1;
		load();
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴 실행
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 4);
		list.add("가는 말이 고와야 오는 말이 곱다");
		list.add("누워서 떡 먹기");
		list.add("윗 물이 맑아야 아랫물이 맑다");
		save();
		
	}
	

	@SuppressWarnings("unchecked")
	public void load() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("load");
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (List<String>)ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			load(fileName);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<String>)ois.readObject();
		} catch (Exception e) {
			
		} 
	}
	
	public void save() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("save");
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {

		} finally {
			save(fileName);
		}
	}
	
	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {

		}
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
