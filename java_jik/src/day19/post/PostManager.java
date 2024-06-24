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
		//수정할 게시글 번호를 입력
		printBar();
		System.out.print("수정할 게시글 번호");
		int num = scan.nextInt();
		printBar();
		
		Post post = selectPost(num);
		if(post == null) {
			return;
		}
		
		printBar();
		//같으면 새 제목과 내용을 입력
		scan.nextLine();//공백처리
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		
		//가져온 객체의 제목과 내용을 입력받은 제목과 내용으로 수정
		post.update(title, content);
		
		//안내문구 출력
		printBar();
		System.out.println(post.getNum() + "번 게시글이 수정되었습니다.");
		
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
	//게시글 번호가 주어지면 게시글을 가져오는 메소드(아이디, 비번 확인 해서)
	public Post selectPost(int num) {
		//입력한 게시글 번호를 이용하여 게시글 객체를 생성
		Post post = new Post(num);
		
		//리스트에서 생성한 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(post);
		
		//일치하는 객체가 없으면(가져온 번지가 0보다 작으면) 알림문구 출력 후 종료
		if(index < 0) {
			printBar();
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return null;
		}
		//아이디, 비번을 입력 받음
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비번 : ");
		String pw = scan.next();
		
		//가져온 객체의 아이디와 비번이 입력받은 아이디와 비번과 같은지 확인해서
		//같지 않으면 안내문구 출력 후 종료
		post = list.get(index);
		if(!post.checkWriter(id, pw)) {
			printBar();
			System.out.println("아이디 또는 비번일 잘못 됐습니다.");
			return null;
		}
		return post;
	}
}







