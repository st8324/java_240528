package db.community.controller;

//출력 전용 컨트롤러. DB 사용하지 X
public class PrintController {

	public static void printMainMenu() {
		System.out.println("-------메인 메뉴-------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}

	public static void printBar() {
		System.out.println("---------------------");
	}

	public static void wrongMenu() {
		System.out.println("잘못된 메뉴를 선택했습니다.");
		
	}

	public static void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	public static void loginFail() {
		System.out.println("로그인 실패!");
	}

	public static void signupSuccess() {
		System.out.println("회원가입 성공!");		
	}

	public static void signupFail() {
		System.out.println("회원가입 실패!");		
	}

	public static void printAdminMenu() {
		System.out.println("------관리자 메뉴------");
		System.out.println("1. 커뮤니티 등록");
		System.out.println("2. 커뮤니티 수정");
		System.out.println("3. 커뮤니티 삭제");
		System.out.println("4. 회원 정지");
		System.out.println("5. 로그아웃");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	public static void logout() {
		System.out.println("로그아웃 합니다.");
	}
	
}
