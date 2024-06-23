package day18.homework.v3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import program.Program;

public class ScheduleManager implements Program {

	private Scanner scan = new Scanner(System.in);
	private List<Member> list = new ArrayList<Member>();
	
	//종료 메뉴
	private final int MEMBER = 1;
	private final int SCHEDULE = 2;
	private final int EXIT = 3;
	
	private String fileName = "src/day18/homework/v3/data.txt";
	
	@Override
	public void printMenu() {
		System.out.print(
				  "------------메인 메뉴---------\r\n"
				+ "1. 회원 관리\r\n"
				+ "2. 일정 관리\r\n"
				+ "3. 종료\r\n"
				+ "----------------------------\n"
				+ "메뉴 선택 : ");
	}

	

	@Override
	public void run() {
		int menu = MEMBER;
		
		load(fileName);
		do {
			
			printMenu();
			try {
				menu = scan.nextInt();
				printBar();
				runMenu(menu);
			} catch(InputMismatchException e) {
				printBar();
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			printBar();
			
		}while(menu != EXIT);
		
		save(fileName);
		
	}
	/**중간 줄을 출력하는 메소드*/
	private void printBar() {
		System.out.println("----------------------------");
	}
	
	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {
			printBar();
			System.out.println("저장에 실패했습니다.");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Member>)ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		} 
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		//회원 관리 메뉴
		case MEMBER:
			runMember();
			break;
		//일정 관리 메뉴
		case SCHEDULE:
			runSchedule();
			break;
		case EXIT:
			exit();
			break;
		default:
			printBar();
			System.out.println("올바른 메뉴를 선택하세요.");
		}
	}
	
	


	private void runMember() {
		MemberType mt = MemberType.INSERT;
		do {
			//회원 메뉴 출력
			printMemberMenu();
			try {
				//회원 메뉴 선택
				int menu = scan.nextInt();
				
				mt = MemberType.fromValue(menu);
				//회원 메뉴 실행
				runMemberMenu(mt);
				
			}
			//메뉴 선택에서 정수를 입력해야 하는데 문자를 입력
			catch(InputMismatchException e) {
				printBar();
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();
			}
			//회원 메뉴 잘못 선택했을 때
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(mt != MemberType.EXIT);
		
	}



	private void printMemberMenu() {

		System.out.print(
				  "------------회원 메뉴---------\r\n"
				+ "1. 회원 추가\r\n"
				+ "2. 회원 수정\r\n"
				+ "3. 회원 삭제\r\n"
				+ "4. 이전으로\r\n"
				+ "----------------------------\n"
				+ "메뉴 선택 : ");
		
	}



	private void runMemberMenu(MemberType mt) {

		switch(mt) {
		case INSERT:	//회원 추가
			memberInsert();
			break;
		case UPDATE:	//회원 수정
			memberUpdate();
			break;
		case DELETE:	//회원 삭제
			memberDelete();
			break;
		case EXIT:		//이전으로
			back();
			break;
		//default는 처리 안해도 됨. 잘못 욉력된 경우 runMemberMenu가 실행되지 않음
		}
		
	}



	private void back() {
		printBar();
		System.out.println("이전으로 돌어갑니다.");
		
	}

	private void memberInsert() {
		//추가할 회원 정보 입력(아이디, 이름)
		System.out.println("추가할 회원 정보 입력");
		System.out.print("아이디(공백없이) : ");
		String id = scan.next();
		System.out.print("이름(공백없이) : ");
		String name = scan.next();
		
		//아이디, 이름으로 객체 생성
		Member member = new Member(id, name);
		
		//가입되어있는지 확인
		//되어 있으면 되어 있다고 안내문구 출력 후 종료
		if(list.contains(member)) {
			printBar();
			System.out.println("이미 가입된 아이디입니다.");
		}
		//가입 안되어 있으면 추가 후 안내문구
		list.add(member);
		printBar();
		System.out.println("회원 가입 되었습니다.");
	}

	private void memberUpdate() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();
		
		//아이디가 있는지 없는지 확인하기 위해 아이디를 이용하여 객체 생성
		Member member = new Member(id, "");
		
		//생성된 객체를 이용해 일치하는 객체가 없으면 안내문구 출력 후 종료
		int index = list.indexOf(member);
		if(index < 0) {
			printBar();
			System.out.println("가입되지 않은 아이디입니다.");
			return;
		}
		
		//있으면 이름 입력 후 이름 수정
		System.out.print("수정할 이름 : ");
		String nmae = scan.next();
		list.get(index).setName(nmae);
		printBar();
		System.out.println("회원 정보를 수정했습니다.");
	}

	private void memberDelete() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();
		
		//아이디가 있는지 없는지 확인하기 위해 아이디를 이용하여 객체 생성
		Member member = new Member(id, "");
		
		//생성된 객체로 삭제가 되면 실패되면 가입되지 않은 아이디 출력
		if(!list.remove(member)) {
			printBar();
			System.out.println("가입되지 않은 아이디입니다.");
			return;
		}
		
		//삭제 됐으면 삭제 완료 문구 출력
		printBar();
		System.out.println("회원 정보를 삭제했습니다.");
	}



	private void runSchedule() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();
		//아이디를 이용하여 객체 생성
		Member member = new Member(id, "");
		//아이디가 없으면 안내문구 출력 후 종료
		if(!list.contains(member)) {
			printBar();
			System.out.println("가입되지 않은 아이디입니다.");
			return;
		}
		
		//있으면 반복문
		
		ScheduleType st = ScheduleType.INSERT;
		do {
			//일정 메뉴 출력
			printScheduleMenu();
			try {
				//일정 메뉴 선택
				int menu = scan.nextInt();
				
				st = ScheduleType.fromValue(menu);
				//회원의 번지를 가져옴(회원 일정 리스트를 가져오기 위해)
				int index = list.indexOf(member);
				//회원 정보에서 일정 리스트를 가져옴
				List<Schedule> sList = list.get(index).getList();
				//선텍한 메뉴와 회원의 일정 정보를 주면서 회원 메뉴 실행
				runScheduleMenu(st, sList);
				
			}
			//메뉴 선택에서 정수를 입력해야 하는데 문자를 입력
			catch(InputMismatchException e) {
				printBar();
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();
			}
			//회원 메뉴 잘못 선택했을 때
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(st != ScheduleType.EXIT);
	}



	private void printScheduleMenu() {
		System.out.print(
				"------------일정 메뉴---------\r\n"
				+ "1. 일정 추가\r\n"
				+ "2. 일정 수정\r\n"
				+ "3. 일정 삭제\r\n"
				+ "4. 일정 확인\r\n"
				+ "5. 이전으로\r\n"
				+ "----------------------------\n"
				+ "메뉴 선택 : ");		
	}



	private void runScheduleMenu(ScheduleType st, List<Schedule> sList) {
		switch(st) {
		case INSERT:
			scheduleInsert(sList);
			break;
		case UPDATE:
			scheduleUpdate(sList);
			break;
		case DELETE:
			scheduleDelete(sList);
			break;
		case SEARCH:
			scheduleSearch(sList);
			break;
		case EXIT:
			back();
		}
		
	}



	private void scheduleInsert(List<Schedule> sList) {
		try {
			//입날짜, 일정, 상세를 입력받아 일정 객체를 생성
			Schedule schedule = inputSchedule();
			
			//생성된 객체를 리스트에 추가
			sList.add(schedule);
			
			//정렬
			sort(sList);
			
			printBar();
			System.out.println("일정이 추가 되었습니다.");
		} catch (ParseException e) {
			printBar();
			System.out.println("올바른 형식의 날짜를 입력하세요.");
		}
	}



	private void scheduleUpdate(List<Schedule> sList) {
		//날짜를 입력받아 일정을 출력하고 수정하려는 일정을 선택해서 객체로 가져옴
		Schedule schedule = selectSchedule("수정", sList);
		//잘못 선택하면
		if(schedule == null) {
			return;
		}
		try {
			//올바른 일정이면 일정 정보를 입력받아 객체를 생성
			Schedule newSchedule = inputSchedule();
			//선택한 객체를 삭제
			sList.remove(schedule);
			//생성된 객체를 추가
			sList.add(newSchedule);
			//정렬
			sort(sList);
			printBar();
			System.out.println("수정이 완료 되었습니다.");
		} catch (ParseException e) {
			printBar();
			System.out.println("올바른 형식의 날짜를 입력하세요.");
		}
	}

	private void scheduleDelete(List<Schedule> sList) {
		//날짜를 입력받아 일정을 출력하고 수정하려는 일정을 선택해서 객체로 가져옴
		Schedule schedule = selectSchedule("삭제", sList);
		
		//잘못 선택하면
		if(schedule == null) {
			return;
		}
		sList.remove(schedule);
		printBar();
		System.out.println("삭제가 완료 되었습니다.");
		
	}



	private void scheduleSearch(List<Schedule> sList) {
		if(sList.size() == 0) {
			printBar();
			System.out.println("등록된 일정이 없습니다.");
			return;
		}
		sList.stream().forEach(s->System.out.println(s));
	}



	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	/**일정정보(날짜, 일정, 상세)를 입력받아 일정 객체를 반환하는 메소드 */
	private Schedule inputSchedule() throws ParseException {
		//날짜, 일정, 상세를 입력
		System.out.print("날짜(yyyy-MM-dd hh:mm) : ");
		scan.nextLine();//엔터 처리
		String date = scan.nextLine();
		System.out.print("일정 : ");
		String toDo = scan.nextLine();
		System.out.print("상세 : ");
		String detail = scan.nextLine();
		return new Schedule(date, toDo, detail);
	}
	/**
	 * 필터 p가 주어지면 주어진 조건에 맞는 리스트 복사본을 가져오는 메소드
	 * @param p 필터할 조건
	 * @return 필터된 복사본
	 */
	private List<Schedule> scheduleFilter(Predicate<Schedule> p, List<Schedule> sList){
		return sList.stream().filter(p).collect(Collectors.toList());
	}
	/**
	 * 주어진 리스트를 번호. 날짜 일정 : 상세 순으로 출력하고 출력된 결과가 있는지
	 * 없는지 알려주는 메소드
	 * @param searchList 출력하려는 리스트
	 * @return 출력 결과가 있는지 없는지
	 */
	private boolean printList(List<Schedule> searchList) {
		if(searchList.size() == 0) {
			printBar();
			System.out.println("일정이 없습니다.");
			return false;
		}
		for(int i = 0; i<searchList.size(); i++) {
			System.out.println(i+1+". " + searchList.get(i));
		}
		return true;
	}
	/**
	 * 스케쥴 리스트를 정렬하는 메소드
	 */
	private void sort(List<Schedule> sList) {
		Collections.sort(sList);
	}
	/**
	 * 날짜를 입력하여 입력한 날짜에 맞는 일정들을 출력하고,
	 * 출력된 일정을 선택하여 객체로 반환하는 메소드(재사용을 위해 만듬)
	 * @param 수정 또는 삭제
	 * @return 선택한 일정 객체
	 */
	private Schedule selectSchedule(String type, List<Schedule> sList) {
		//날짜 입력
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.next();
		if(!checkDate(date)) {
			printBar();
			System.out.println("올바른 형식의 날짜를 입력하세요.");
			return null;
		}
		//해당 날짜에 있는 모든 일정을 리스트로 가져옴
		List<Schedule> searchList = 
			scheduleFilter(s->s.getDateStr().substring(0, 10).equals(date), sList);
		//맞는 일정들을 출력하고 출력할 내용이 없으면 종료
		if(!printList(searchList)) {
			return null;
		}
		//일정을 선택
		System.out.print(type + "할 일정 선택 : ");
		int index = scan.nextInt() - 1;
		//올바르지 않은 일정이면 종료
		if(index < 0 || index >= searchList.size()) {
			printBar();
			System.out.println("올바른 일정을 선택하세요.");
			return null;
		}
		return searchList.get(index);
	}
	/**
	 * 문자열이 날짜 형식인지 알려주는 메소드
	 * @param str 날짜 형식 문자열
	 * @return 문자열이 날짜 형식인지 아닌지
	 */
	private boolean checkDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.parse(str);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
