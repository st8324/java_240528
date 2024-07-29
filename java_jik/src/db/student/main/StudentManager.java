package db.student.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import db.student.controller.ScoreController;
import db.student.controller.StudentController;
import db.student.controller.SubjectController;
import program.Program;

public class StudentManager implements Program{

	private Scanner scan = new Scanner(System.in);

	private StudentController studentController = new StudentController(scan);
	private SubjectController subjectController = new SubjectController(scan);
	private ScoreController scoreController = new ScoreController(scan);
	
	@Override
	public void printMenu() {
		System.out.print(
				  "메뉴\n"
				+ "1. 학생 관리\n"
				+ "2. 과목 관리\n"
				+ "3. 종료\n"
				+ "메뉴 선택 : ");
	}


	@Override
	public void run() {
		
		int menu;
		do {
			printMenu();
			
			menu = nextInt();
			
			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 3);
	}
	
	
	/**
	 * 콘솔에서 정수를 입력받아 반환하는 메소드로 잘못입력하면(문자열) 정수의 가장 작은 수를 반환
	 * @return 입력한 정수 또는 정수의 가장 작은 수
	 */
	public int nextInt() {
		try {
			return scan.nextInt();
		}catch(InputMismatchException e) {
			scan.nextLine();//잘못 입력한 값을 입력 버퍼에 비워줌
			return Integer.MIN_VALUE;//int의 가장 작은 수를 리턴
		}
	}

	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {
		case 1:
			student();
			break;
		case 2:
			subject();
			break;
		case 3:
			exit();
			break;
		default:
			
		}
		
	}


	private void student() {
		int menu;
		do {
			printStudentMenu();
			menu = nextInt();
			runStudentMenu(menu);
		}while(menu != 5);
		
	}


	private void printStudentMenu() {
		System.out.print(
				  "학생 관리 메뉴\n"
				+ "1. 학생 추가\n"
				+ "2. 학생 수정\n"
				+ "3. 학생 삭제\n"
				+ "4. 학생 조회\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}


	private void runStudentMenu(int menu) {
		switch (menu) {
		case 1:
			studentController.insertStudent();
			break;
		case 2:
			studentUpdate();
			break;
		case 3:
			studentController.deleteStudent();
			break;
		case 4:
			studentController.selectStudent();
			break;
		case 5:
			prev();
			break;
		default:
			
		}
		
	}

	private void studentUpdate() {
		int menu;
		do {
			printStudentUpdateMenu();
			menu = nextInt();
			runStudentUpdateMenu(menu);
		}while(menu != 5);
		
	}

	private void printStudentUpdateMenu() {
		System.out.print(
				  "학생 수정 메뉴\n"
				+ "1. 학생 정보 수정\n"
				+ "2. 성적 추가\n"
				+ "3. 성적 수정\n"
				+ "4. 성적 삭제\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
		
	}


	private void runStudentUpdateMenu(int menu) {
		switch(menu) {
		case 1:
			studentController.updateStudent();
			break;
		case 2:
			scoreController.insertScore();
			break;
		case 3:
			scoreController.updateScore();
			break;
		case 4:
			scoreController.deleteScore();
			break;
		case 5:
			prev();
			break;
		default:
			defaultPrint();
		}
		
	}
	
	private void subject() {

		int menu;
		do {
			printSubjectMenu();
			menu = nextInt();
			runSubjectMenu(menu);
		}while(menu != 5);
		
	}

	private void printSubjectMenu() {
		System.out.print("과목 관리 메뉴\n"
				+ "1. 과목 추가\n"
				+ "2. 과목 수정\n"
				+ "3. 과목 삭제\n"
				+ "4. 과목 확인\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}


	private void runSubjectMenu(int menu) {
		switch(menu) {
		case 1:
			subjectController.insertSubject();
			break;
		case 2:
			subjectController.updateSubject();
			break;
		case 3:
			subjectController.deleteSubject();
			break;
		case 4:
			subjectController.selectSubject();
			break;
		case 5:
			prev();
			break;
		default:
			defaultPrint();
		}
		
	}

	private void prev() {
		System.out.println("이전으로 돌아갑니다.");		
	}
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	private void defaultPrint() {
		System.out.println("올바른 메뉴를 선택하세요.");
	}
}
