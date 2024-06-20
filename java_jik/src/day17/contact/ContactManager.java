package day17.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class ContactManager implements Program {
	
	private List<Contact> list = new ArrayList<Contact>();
	private Scanner scan = new Scanner(System.in);

	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	@Override
	public void printMenu() {
		System.out.println("-----------");
		System.out.print("메뉴\n"
				+ "1. 연락처 추가\n"
				+ "2. 연락처 수정\n"
				+ "3. 연락처 삭제\n"
				+ "4. 연락처 검색\n"
				+ "5. 프로그램 종료\n"
				+ "메뉴 선택 : ");
	}

		@Override
	public void run() {
		String fileName = "src/day17/contact/contact.txt";
		
		load(fileName);
		//list = new ArrayList<Contact>();
		//프로그램 실행
		int menu = INSERT;
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//선택한 메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();//입력 버퍼에 남은 값들을 비워 줌
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}while(menu != EXIT);
		
		save(fileName);
	}

	@Override
	public void save(String fileName) {
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {
			System.out.println("저장에 실패했습니다.");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Contact>)ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		} 
		
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 올바른 메뉴를 선택하세요.");
		}
	}

	private void update() {
		//이름을 받고
		System.out.print("입력 : ");
		scan.nextLine();
		String name = scan.nextLine();
		//이름이 포함된 연락처들을 리스트(A)로 받음
		List<Contact> tmps = 
				list.stream().filter(c->c.getName().contains(name))
							 .collect(Collectors.toList());
		
		//검색 결과가 없는 경우
		if(tmps.size() == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return;
		}
		
		//받은 리스트를 이용하여 출력(번호와 함께)
		for(int i = 0; i<tmps.size(); i++) {
			System.out.println(i+1+". " + tmps.get(i));
		}
		//번호를 선택
		System.out.print("번호 : ");
		int index = scan.nextInt() - 1;
		
		//번호가 0미만이고 A.size()보다 크거나 같으면 안내문구 출력후 종료
		if(index < 0 || index >= tmps.size()) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		//아니면 해당 객체를 가져옴
		Contact tmp = tmps.get(index);
		
		//이름, 번호를 입력받음
		System.out.print("이름 : ");
		scan.nextLine();
		String newName = scan.nextLine();
		System.out.print("번호 : ");
		String newNumber = scan.nextLine();
		
		//list에서 tmp를 제거한 리스트(원본은 그대로이어야 함)B를 가져옴
		List<Contact> copyList 
			= list.stream().filter(c->!c.equals(tmp))
							.collect(Collectors.toList());
					
		//리스트 B에 있는 연락처중에서 입력한 번호와 같은 번호가 있는지 확인
		long count = copyList.stream()
							 .filter(c->c.getNumber().equals(newNumber))
							 .count();
		//있으면 안내문구 출력 후 종료
		if(count != 0) {
			System.out.println("이미 등록된 번호입니다.");
			return;
		}
		//없으면 tmp를 제거
		list.remove(tmp);
		//이름, 번호를 이용하여 객체 생성
		Contact newContact = new Contact(newNumber, newName);
		//list에 추가
		list.add(newContact);
	}

	private void delete() {
		//이름을 받고
		System.out.print("입력 : ");
		scan.nextLine();
		String name = scan.nextLine();
		//이름이 포함된 연락처들을 리스트(A)로 받음
		List<Contact> tmps = 
				list.stream().filter(c->c.getName().contains(name))
							 .collect(Collectors.toList());
		
		//검색 결과가 없는 경우
		if(tmps.size() == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return;
		}
		
		//받은 리스트를 이용하여 출력(번호와 함께)
		for(int i = 0; i<tmps.size(); i++) {
			System.out.println(i+1+". " + tmps.get(i));
		}
		//번호를 선택
		System.out.print("번호 : ");
		int index = scan.nextInt() - 1;
		
		//번호가 0미만이고 A.size()보다 크거나 같으면 안내문구 출력후 종료
		if(index < 0 || index >= tmps.size()) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		//아니면 해당 객체를 가져옴
		Contact tmp = tmps.get(index);
		//리스트에서 해당 객체와 같은 객체를 제거
		list.remove(tmp);
	}

	private void insert() {
		//이름, 번호를 입력
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("번호 : ");
		String number = scan.nextLine();
		
		//등록된 번호가 있으면 이미 등록된 번호가 있습니다.라고 출력하고 종료
		long count = list.stream().filter(c->c.getNumber().equals(number)).count();
		if(count > 0 ) {
			System.out.println("이미 등록된 번호가 있습니다.");
			return;
		}
		//없으면 이름, 번호를 이용해서 객체를 생성
		Contact c = new Contact(number, name);
		//객체를 리스트에 추가
		list.add(c);
	}

	private void search() {
		//원하는 단어를 입력
		System.out.print("검색 : ");
		scan.nextLine();//엔터 처리
		String search = scan.nextLine();
		
		//일치하는 연락처가 없는 경우 안내문구 출력 후 종료
		long count = list.stream().filter(c->c.getName().contains(search))
								  .count();
		if(count == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return;
		}
		
		//스트림을 이용해서 name에 단어가 포함된 객체들만 필터링해서 toString으로 출력
		list.stream().filter(c->c.getName().contains(search))
					 .forEach(c->System.out.println(c));
	}
}
