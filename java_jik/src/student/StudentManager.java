package student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class StudentManager implements Program{

	//학생 성적 관리를 위한 리스트
	private List<Student> list = new ArrayList<Student>();
	//과목 관리를 위한 리스트
	private List<Subject> subjectList = new ArrayList<Subject>();
	private Scanner scan = new Scanner(System.in);
	
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
			studentInsert();
			break;
		case 2:
			studentUpdate();
			break;
		case 3:
			studentDelete();
			break;
		case 4:
			studnetSearch();
			break;
		case 5:
			prev();
			break;
		default:
			
		}
		
	}

	private void studentInsert() {
		//입력한 정보를 이용하여 객체를 생성
		Student std = inputStudentExpand();
		//객체가 리스트에 있으면 안내문구 출력 후 종료
		if(list.contains(std)) {
			System.out.println("이미 등록된 학년, 반, 번호입니다.");
			return;
		}
		//없으면 추가 후 안내문구 출력
		list.add(std);
		System.out.println("학생이 추가되었습니다.");
	}
	/**학년 반 번호를 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * @return 학년, 반, 번호가 있는 만들어진 학생 객체
	 * */
	public Student inputStudent() {
		//학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = nextInt();
		System.out.print("반 : ");
		int classNum = nextInt();
		System.out.print("번호 : ");
		int num = nextInt();
		return new Student(grade, classNum, num, "");
	}
	/**학년 반 번호 이름을 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * @return 학년, 반, 번호, 이름이 있는 만들어진 학생 객체
	 */
	public Student inputStudentExpand() {
		Student std = inputStudent();
		
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		std.setName(name);
		return std;
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
		// TODO Auto-generated method stub
		
	}


	private void studentDelete() {
		//학년, 반, 번호를 입력해서 학생 객체를 생성
		Student std = inputStudent();
		//리스트에서 학생 객체를 삭제하고 삭제에 성공하면 알림문구 출력 후 종료
		if(list.remove(std)) {
			System.out.println("학생을 삭제했습니다.");
			System.out.println(list);
			return;
		}
		//아니면 알림문구 출력
		System.out.println("일치하는 학생이 없습니다.");
	}


	private void studnetSearch() {
		//학년 반 번호를 입력 후 객체를 생성
		Student std = inputStudent();
		
		//생성된 객체와 일치하는 객체를 가져옴
		//리스트에서 객체와 일치하는 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 0보다 작으면 객체에 null을 저장
		if(index < 0) {
			std = null;
		}
		//아니면 객체에 번지에 있는 객체를 가져옴
		else {
			std = list.get(index);
		}
		//가져온 객체가 null이면 안내문구 출력 후 종료
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//null이 아니면 학생 정보를 출력
		std.print();
	}


	private void prev() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}


	private void exit() {
		// TODO Auto-generated method stub
		
	}
}
