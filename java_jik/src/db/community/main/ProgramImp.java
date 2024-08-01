package db.community.main;

import java.util.Scanner;

import db.community.controller.MemberController;
import db.community.controller.PostController;
import db.community.controller.PrintController;
import db.community.model.vo.MemberVO;
import db.community.model.vo.PostVO;
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
		cri.setPerPageNum(2);
		do {
			PrintController.printBar();
			System.out.println(cri.getPage() + "페이지 결과입니다.(검색어 : '" + cri.getSearch() + "')");
			PrintController.printBar();
			PageMaker pm = postController.getPageMaker(cri, Integer.MAX_VALUE);
			//컨트롤러가 페이저 정보(검색어, 커뮤니티 번호)에 맞는 게시글 리스트를 출력
			postController.printPostList(cri);
			//메뉴를 출력
			PrintController.printPostMenu();
			//메뉴를 선택
			menu = scan.next().charAt(0);
			PrintController.printBar();
			//선택한 메뉴를 실행
			runPostMenu(menu, pm);
			PrintController.printBar();
		}while(menu != '5');
		
	}

	private void runPostMenu(char menu, PageMaker pm) {
		switch(menu) {
		case '1':
			page(pm, -1);
			break;
		case '2':
			page(pm, 1);
			break;
		case '3':
			search(pm);
			break;
		case '4':
			detail();
			break;
		case '5':
			PrintController.prev();
			break;
		default:
			PrintController.wrongMenu();
		}
		
	}

	private void detail() {
		//게시글 출력
		PostVO post = postController.printPostDetail();
		PrintController.printBar();
		if(post == null) {
			return;
		}
		char menu = '0';
		do {
			PrintController.printPostSubMenu(post.getPo_me_id().equals(member.getMe_id()));
			
			menu = scan.next().charAt(0);
			PrintController.printBar();
			
			runPostSubMenu(menu, post);
			PrintController.printBar();
			//삭제 시 게시글 상세에 더 머물 필요가 없어서 빠져 나가게 함
			if(post.getPo_num() == 0) {
				break;
			}
		}while(menu != '3');
		
	}

	private void runPostSubMenu(char menu, PostVO post) {
		switch(menu) {
		case '1':
			break;
		case '2':
			break;
		case '3':
			PrintController.prev();
			break;
		case '4':
			postUpdate(post);
			break;
		case '5':
			postDelete(post);
			break;
		default:
			PrintController.wrongMenu();
		}
		
	}

	private void postUpdate(PostVO post) {
		if(post == null) {
			return;
		}
		//작성자인지 확인
		if(!post.getPo_me_id().equals(member.getMe_id())) {
			PrintController.notWriter();
			return;
		}
		if(postController.updatePost(post.getPo_num())) {
			System.out.println("게시글 수정 성공!");
		}else {
			System.out.println("게시글 수정 실패!");
		}
	}

	private void postDelete(PostVO post) {
		if(post == null) {
			return;
		}
		//작성자인지 확인
		if(!post.getPo_me_id().equals(member.getMe_id())) {
			PrintController.notWriter();
			return;
		}
		if(postController.deletePost(post.getPo_num())) {
			System.out.println("게시글 삭제 성공!");
			post.setPo_num(0);
		}else {
			System.out.println("게시글 삭제 실패!");
		}
		
	}

	private void search(PageMaker pm) {
		//검색어 입력
		System.out.print("검색어 : ");
		scan.nextLine();
		String search = scan.nextLine();
		//페이지메이커의 검색어를 입력받은 검색어로 수정
		pm.getCri().setSearch(search);
		
	}

	private void page(PageMaker pm, int add) {
		int page = pm.getCri().getPage(); 
		if(add > 0 && pm.isNext()) {
			pm.getCri().setPage(page + 1);
		}else if(add < 0 && pm.isPrev()) {
			pm.getCri().setPage(page - 1);
		}else if(add > 0){
			System.out.println("마지막 페이지입니다.");
		}else {
			System.out.println("처음 페이지입니다.");
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
