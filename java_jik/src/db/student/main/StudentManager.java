package db.student.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import db.student.controller.StudentController;
import db.student.controller.SubjectController;
import program.Program;

public class StudentManager implements Program{

	private Scanner scan = new Scanner(System.in);

	private StudentController studentController = new StudentController(scan);
	private SubjectController subjectController = new SubjectController(scan);
	
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
			//insertSubejctScore();
			break;
		case 3:
			//updateSubjectScore();
			break;
		case 4:
			//deleteSubjectScore();
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
			//deleteSubject();
			break;
		case 4:
			//searchSubject();
			break;
		case 5:
			prev();
			break;
		default:
			defaultPrint();
		}
		
	}

/*
	private void insertSubejctScore() {
		//등록된 과목이 없으면 알림문구 출력 후 종료
		if(subjectList.size() == 0) {
			System.out.println("등록된 과목이 없어서 추가할 수 없습니다. 과목을 등록해주세요.");
			return;
		}
		
		//학생 정보 입력(학년, 반, 번호)를 입력해서 학생 객체를 생성
		StudentVO std = inputStudent();
		//리스트에 입력한 학생 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않으면 안내문구 출력 후 종료
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//리스트에서 번지에 있는 학생 정보를 가져옴
		std = list.get(index);
		//등록된 과목 리스트를 출력
		searchSubject();
		//학년, 학기, 과목명, 중간, 기말, 수행평가를 입력한 후 과목 객체를 생성
		SubjectVO subject = inputSubject();
		
		//입력한 과목이 과목 리스트에 없으면 안내문구 출력 후 종료
		if(!subjectList.contains(subject.getName())) {
			System.out.println("등록되지 않은 과목이어서 성적을 추가할 수 없습니다.");
			return;
		}
		
		//학생의 과목 리스트를 가져옴
		List<SubjectVO> tmpList = std.getSubjectList();
		//학생의 과목 리스트에 생성한 과목 객체가 있으면 안내문구 출력 후 종료
		if(tmpList.contains(subject)) {
			System.out.println("과목 성적이 이미 등록 되어 있습니다.");
			return;
		}
		//없으면 학생의 과목 리스트에 추가
		tmpList.add(subject);
		System.out.println("학생 성적을 등록했습니다.");
		
	}


	private SubjectVO inputSubject() {
		SubjectVO subject = inputRequiredSubject();
		System.out.print("중간 : ");
		int midterm = nextInt();
		System.out.print("기말 : ");
		int finals = nextInt();
		System.out.print("수행 : ");
		int performace = nextInt();
		subject.update(midterm, finals, performace);
		return subject;
	}


	private void updateSubjectScore() {
		//학생 정보를 입력하여 객체를 생성
		StudentVO std = inputStudent();
		//학생 리스트에서 학생 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않으면 알림문구 출력 후 종료
		if(index < 0) {
			System.out.println("일차하는 학생이 없습니다.");
			return;
		}
		//번지에 있는 학생 객체를 가져옴
		std = list.get(index);
		
		//학생의 과목 리스트를 가져옴
		List<SubjectVO> subjects = std.getSubjectList();
		
		//삭제할 과목, 학년, 학기 정보를 입력
		//과목, 학년, 학기를 이용해서 객체를 생성
		SubjectVO subject = inputRequiredSubject();
		
		//과목이 과목리스트에 없으면 안내문구 출력 후 종료
		if(!subjectList.contains(subject.getName())) {
			System.out.println("등록되지 않은 과목이어서 삭제할 수 없습니다.");
			return;
		}
		
		//과목 객체가 학생 성적 리스트에 없으면 안내문구 출력 후 종료
		if(!subjects.contains(subject)) {
			System.out.println("등록되지 않은 과목 성적이어서 삭제할 수 없습니다.");
			return;
		}
		//중간, 기말, 수행평가를 입력
		System.out.print("중간 : ");
		int midterm = nextInt();
		System.out.print("기말 : ");
		int finals = nextInt();
		System.out.print("수행 : ");
		int performace = nextInt();
		
		//과목 객체의 성적을 수정
		subject.update(midterm, finals, performace);
		
		//제거하고 추가하는 이유는 이렇게 하지 않으면
		//subjects에서 해당 과목이 몇번에 있는지 확인해서 해당 과목 정보를 가져오고
		//성적을 수정해야하는데 번거롭기 때문에 아래와 같이 작성
		//리스트에서 과목 객체를 제거
		subjects.remove(subject);
		//리스트에서 과목 객체를 추가
		subjects.add(subject);
		System.out.println("과목 성적을 수정했습니다.");
		
	}


	private void deleteSubjectScore() {
		//학생 정보를 입력하여 객체를 생성
		StudentVO std = inputStudent();
		//학생 리스트에서 학생 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않으면 알림문구 출력 후 종료
		if(index < 0) {
			System.out.println("일차하는 학생이 없습니다.");
			return;
		}
		//번지에 있는 학생 객체를 가져옴
		std = list.get(index);
		
		//학생의 과목 리스트를 가져옴
		List<SubjectVO> subjects = std.getSubjectList();
		
		//삭제할 과목, 학년, 학기 정보를 입력
		//과목, 학년, 학기를 이용해서 객체를 생성
		SubjectVO subject = inputRequiredSubject();
		
		//과목이 과목리스트에 없으면 안내문구 출력 후 종료
		if(!subjectList.contains(subject.getName())) {
			System.out.println("등록되지 않은 과목이어서 삭제할 수 없습니다.");
			return;
		}
		
		//학생 과목 리스트에서 과목 객체를 삭제하여 성공하면 안내문구 출력 후 종료
		if(subjects.remove(subject)) {
			System.out.println("과목 성적을 삭제했습니다.");
			return;
		}
		//실패하면 안내문구 출력 후 종료
		System.out.println("등록되지 않은 과목 성적이어서 삭제할 수 없습니다.");
		
	}

	public SubjectVO inputRequiredSubject() {
		System.out.print("과목 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("학년 : ");
		int grade = nextInt();
		System.out.print("학기 : ");
		int semester = nextInt();
		return new SubjectVO(name, grade, semester, 0, 0, 0);
	}
	
		
	private void deleteSubject() {
		//삭제할 과목명을 입력
		System.out.print("과목 : ");
		scan.nextLine();
		String subject = scan.nextLine();
		//리스트에서 과목을 삭제해서 성공하면 알림문구 출력 후 종료
		if(subjectList.remove(subject)) {
			System.out.println("과목을 삭제했습니다.");
			return;
		}
		//실패하면 알림문구 출력
		System.out.println("등록되지 않은 과목입니다.");
	}


	private void searchSubject() {
		System.out.println("과목 목록");
		for(String subject : subjectList) {
			System.out.println(subject);
		}
		
	}


	
	*/
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
