package day19.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class PostManager implements Program {

	private Scanner scan = new Scanner(System.in);
	private List<Post> list = new ArrayList<Post>();
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	private String fileName = "src/day19/post/data.txt";
	
	@Override
	public void printMenu() {
		
	}

	@Override
	public void run() {
		int menu;
		load(fileName);
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴 실행
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}
		}while(menu != EXIT);
		
		save(fileName);
	}
	
	@Override
	public void save(String fileName) {
		
	}
	@Override
	public void load(String fileName) {
		
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			break;
		case UPDATE:
			break;
		case DELETE:
			break;
		case SEARCH:
			break;
		case EXIT:
			break;
		default:
		}
	}
}
