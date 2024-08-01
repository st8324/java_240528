package db.community.main;

import java.util.Scanner;

import db.community.controller.MemberController;
import db.community.controller.PostController;
import db.community.controller.PrintController;
import db.community.model.vo.MemberVO;
import db.community.pagination.Criteria;
import db.community.pagination.PageMaker;
import db.community.pagination.PostCriteria;
import program.Program;

public class ProgramImp implements Program {

	private Scanner scan = new Scanner(System.in);
	private MemberVO member = null;
	private MemberController memberController = new MemberController(scan);
	private PostController postController = new PostController(scan);
	
	@Override
	public void printMenu() {
		PrintController.printMainMenu();
	}

	@Override
	public void run() {
		char menu = '0';
		
		do {
			printMenu();
			
			
			try {
				menu = scan.next().charAt(0);
				
				PrintController.printBar();

				runMenu(menu);
				
				PrintController.printBar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != '3');
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		char ch = (char)menu;
		switch(ch) {
		case '1':
			login();
			break;
		case '2':
			signup();
			break;
		case '3':
			PrintController.exit();
			break;
		default:
			PrintController.wrongMenu();
			
		}
		
		
	}

	private void login() {
		//회원 정보를 입력받아 회원 정보와 일치하는 회원의 정보를 가져옴
		member = memberController.login();

		//회원 정보가 없으면
		if(member == null) {
			PrintController.loginFail();
			return;
		}
		//관리자이면 관리자 기능을 실행 
		if(member.getMe_authority().equals("ADMIN")) {
			admin();
			return;
		}
		//회원이면 회원 기능을 실행
		user();
	}

	private void user() {
		PrintController.printBar();
		System.out.println(member.getMe_id()+"님 환영합니다.");
		PrintController.printBar();
		char menu = '0';
		do {
			PrintController.printUserMenu();
			
			menu = scan.next().charAt(0);
			PrintController.printBar();
			
			runUser(menu);
		}while(menu != '3');
	}

	private void runUser(char menu) {
		switch(menu) {
		case '1':
			postController.insertPost(member.getMe_id());
			break;
		case '2':
			search();
			break;
		case '3':
			PrintController.logout();
			break;
		default:
			PrintController.wrongMenu();
		}
		
	}

	private void search() {
		char menu = '0';
		//커뮤니티 선택
		//커뮤니티 출력
		postController.printCommunityList();
		PrintController.printBar();
		//커뮤니티 선택
		System.out.print("커뮤니티 번호 선택 : ");
		int coNum = scan.nextInt();
		Criteria cri = new PostCriteria(1, "", coNum);
		do {
			PageMaker pm = postController.getPageMaker(cri, Integer.MAX_VALUE);
			//컨트롤러가 페이저 정보(검색어, 커뮤니티 번호)에 맞는 게시글 리스트를 출력
			postController.printPostList(cri);
			//메뉴를 출력
			PrintController.printPostMenu();
			//메뉴를 선택
			menu = scan.next().charAt(0);
			//선택한 메뉴를 실행
			runPostMenu(menu, );
		}while(menu != '5');
		
	}

	private void runPostMenu(char menu) {
		switch(menu) {
		case '1':
			break;
		case '2':
			break;
		case '3':
			break;
		case '4':
			postController.printPostDetail();
			break;
		case '5':
			PrintController.prev();
			break;
		default:
			PrintController.wrongMenu();
		}
		
	}

	private void admin() {
		PrintController.printBar();
		System.out.println("관리자님 환영합니다.");
		PrintController.printBar();
		char menu = '0';
		do {
			PrintController.printAdminMenu();
			
			menu = scan.next().charAt(0);
			PrintController.printBar();
			
			runAdmin(menu);
		}while(menu != '5');
	}

	private void runAdmin(char menu) {
		
		switch(menu) {
		case '1':
			postController.insertCommunity();
			break;
		case '2':
			postController.updateCommunity();
			break;
		case '3':
			postController.deleteCommunity();
			break;
		case '4':
			break;
		case '5':
			PrintController.logout();
			break;
		default:
			PrintController.wrongMenu();
		}
		
	}

	private void signup() {
		
		if(memberController.signup()) {
			PrintController.signupSuccess();
		}else {
			PrintController.signupFail();
		}
		
	}

}
