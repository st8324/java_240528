package account.v1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class AccountManager implements Program {

	private List<Item> list = new ArrayList<Item>();
	private Scanner scan = new Scanner(System.in);
	private List<String> incomeCategoryList = Arrays.asList("월급", "용돈", "부수입");
	private List<String> expensesCategoryList = Arrays.asList("교통비", "식비", "취미", "기타");
	private String fileName = "src/account/v1/data.txt";
	
	@Override
	public void printMenu() {
		System.out.print(
				  "--------메뉴---------\n"
				+ "1. 내역 입력\n"
				+ "2. 내역 수정\n"
				+ "3. 내역 삭제\n"
				+ "4. 내역 조회\n"
				+ "5. 종료\n"
				+ "-------------------\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Item>)ois.readObject();
		} catch (Exception e) {
		} 
	}

	@Override
	public void run() {
		
		int menu;
		load(fileName);
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외 발생");
			}
			
		}while(menu != 5);
		save(fileName);
	}

	private void printBar() {
		System.out.println("-------------------");
	}
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		case 5:
			exit();
			break;
		default:
			wrongMenu();
		}
	}

	private void insert() {
		//1. 내역 입력
		//내역 입력 후 입력한 내용을 이용하여 객체 생성
		Item item = inputItem();
		//2. 내역 추가
		//리스트에 객체 추가
		list.add(item);
		//날짜 순으로 정렬
		Collections.sort(list);
		//안내문구 출력
		printBar();
		System.out.println("내역을 추가했습니다.");
	}

	private Item inputItem() {
		printBar();
		System.out.print("날짜 : ");
		String date = scan.next();
		System.out.print("수입/지출 : ");
		String type = scan.next();
		System.out.println("분류 목록");
		//수입 지출에 따라 분류를 출력하기 위해 타입에 맞는 카테고리를 선택
		//수입이면 incomeCategoryList, 지출이면 expensesCategoryList 선택
		List<String> tmpList = type.equals("수입")? incomeCategoryList : expensesCategoryList;
		for(String category : tmpList) {
			System.out.println(category);
		}
		System.out.print("분류 : ");
		String category = scan.next();
		System.out.print("금액 : ");
		int amount = scan.nextInt();
		System.out.print("내용 : ");
		scan.nextLine();
		String contents = scan.nextLine();
		return new Item(date, type, category, amount, contents);
	}

	private void update() {
		//1. 검색
		search();
		
		//2. 수정할 내역 선택
		printBar();
		System.out.print("내역 선택 : ");
		int index = scan.nextInt() - 1;
		//3. 내역 삭제
		try {
			list.remove(index);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 번호를 선택해서 수정하지 못했습니다.");
			return;
		}
		//4. 수정할 내역 입력
		Item item = inputItem();
		//5. 새 내역 추가
		list.add(item);
		//정렬
		Collections.sort(list);
		printBar();
		System.out.println("내역을 수정했습니다.");
	}

	private void delete() {
		//1. 검색
		search();
		
		//2. 삭제할 내역 선택
		printBar();
		System.out.print("내역 선택 : ");
		int index = scan.nextInt() - 1;
		//3. 내역 삭제
		try {
			printBar();
			list.remove(index);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 번호를 선택해서 삭제하지 못했습니다.");
			return;
		}
		System.out.println("내역을 삭제했습니다.");
	}

	private void search() {
		//1. 날짜 선택
		printBar();
		//날짜 입력
		System.out.print("날짜 : ");
		String date = scan.next();
		//날짜를 이용해 객체 생성(내역 출력 시 편하게 출력하기 위해)
		Item item = new Item(date, "", "", 0, "");
		
		//2. 내역 출력
		printItemList(item);
	}
	//주어진 내역의 날짜와 날짜가 같은 내역들을 출력
	private void printItemList(Item item) {
		
		printBar();
		for(int i = 0; i<list.size(); i++) {
			if(item.equals(list.get(i))) {
				System.out.println(i+1 + ". " + list.get(i));
			}
		}
	}
	
	private void exit() {
		printBar();
		System.out.println("프로그램을 종료합니다.");
		printBar();
	}

	private void wrongMenu() {
		printBar();
		System.out.println("잘못된 메뉴를 선택했습니다.");
	}


}
