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
		System.out.print("---------------------\r\n"
				+ "메뉴\r\n"
				+ "1. 게시글 등록\r\n"
				+ "2. 게시글 수정\r\n"
				+ "3. 게시글 삭제\r\n"
				+ "4. 게시글 검색\r\n"
				+ "5. 프로그램 종료\r\n"
				+ "---------------------\r\n"
				+ "메뉴 선택 : ");
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
			printBar();
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
			insert();
			System.out.println(list);
			break;
		case UPDATE:
			update();
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

	private void update() {
		
		
	}

	private void insert() {
		//게시글 정보를 입력
		scan.nextLine();//공백 처리
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String id = scan.next();
		System.out.print("비번 : ");
		String pw = scan.next();
		//입력한 정보를 이용해서 게시글 객체를 생성
		Post post = new Post(title, contents, id, pw);
		//생성한 게시글 객체를 리스트에 추가
		list.add(post);
		//알림문구를 출력
		printBar();
		System.out.println(post.getNum() + "번 게시글이 추가되었습니다.");
	}
	
	
	
	public void printBar() {
		System.out.println("---------------------");
	}
}







