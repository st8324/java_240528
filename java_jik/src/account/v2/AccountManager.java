package account.v2;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class AccountManager implements Program {
	
	private Scanner scan = new Scanner(System.in);
	private AccountBook ab = new AccountBook();
	private String fileName = "src/account/v2/data.txt";

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
	public void run() {
		int menu = 1;
		load(fileName);
		do {
			printMenu();
			
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e){
				System.out.println("메뉴는 정수입니다. 올바른 메뉴를 입력하세요.");
				scan.nextLine();
			}catch (Exception e) {
				System.out.println("예외 발생");
			}
			
		}while(menu != 5);
		save(fileName);
		
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

	public void printBar() {
		System.out.println("---------------");
	}

	private void insert() {
		Item item = inputItem();
		if(item == null) {
			printBar();
			System.out.println("날짜를 잘못 입력했습니다.");
			return;
		}
		printBar();
		if(ab.insert(item)) {
			System.out.println("내역을 추가했습니다.");
		}else {
			System.out.println("잘못 입력된 내용이 있어서 내역을 추가하지 못했습니다.");
		}
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
		List<String> tmpList = 
			type.equals("수입")? AccountBook.incomeCategoryList : AccountBook.expensesCategoryList;
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
		try {
			return new Item(date, type, category, amount, contents);
		} catch (ParseException e) {
			return null;
		}
	}


	private void update() {
		// TODO Auto-generated method stub
		
	}



	private void delete() {
		// TODO Auto-generated method stub
		
	}



	private void search() {
		// TODO Auto-generated method stub
		
	}



	private void exit() {
		// TODO Auto-generated method stub
		
	}



	private void wrongMenu() {
		// TODO Auto-generated method stub
		
	}

}
