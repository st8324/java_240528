package day18.homework.v2;

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
	
	private List<Schedule> list = new ArrayList<Schedule>();
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	private String fileName = "src/day18/homework/v2/data.txt";
	
	@Override
	public void printMenu() {
		System.out.print(
				  "--------------메뉴------------\r\n"
				+ "1. 일정 추가\r\n"
				+ "2. 일정 수정\r\n"
				+ "3. 일정 삭제\r\n"
				+ "4. 일정 확인\r\n"
				+ "5. 프로그램 종료\r\n"
				+ "----------------------------\n"
				+ "메뉴 선택 : ");
	}

	

	@Override
	public void run() {
		int menu = INSERT;
		
		load(fileName);
		do {
			
			printMenu();
			try {
				menu = scan.nextInt();
				printBar();
				runMenu(menu);
			} catch(InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();
			} catch (Exception e) {
				//e.printStackTrace();
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
			System.out.println("저장에 실패했습니다.");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Schedule>)ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		} 
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case EXIT:
			exit();
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
	}
	
	


	private void insert() {
		try {
			//입날짜, 일정, 상세를 입력받아 일정 객체를 생성
			Schedule schedule = inputSchedule();
			
			//생성된 객체를 리스트에 추가
			list.add(schedule);
			
			//정렬
			sort();
			
			printBar();
			System.out.println("일정이 추가 되었습니다.");
		} catch (ParseException e) {
			printBar();
			System.out.println("올바른 형식의 날짜를 입력하세요.");
		}
	}



	private void update() {
		//날짜를 입력받아 일정을 출력하고 수정하려는 일정을 선택해서 객체로 가져옴
		Schedule schedule = selectSchedule("수정");
		//잘못 선택하면
		if(schedule == null) {
			return;
		}
		try {
			//올바른 일정이면 일정 정보를 입력받아 객체를 생성
			Schedule newSchedule = inputSchedule();
			//선택한 객체를 삭제
			list.remove(schedule);
			//생성된 객체를 추가
			list.add(newSchedule);
			//정렬
			sort();
			printBar();
			System.out.println("수정이 완료 되었습니다.");
		} catch (ParseException e) {
			printBar();
			System.out.println("올바른 형식의 날짜를 입력하세요.");
		}
	}

	private void delete() {
		//날짜를 입력받아 일정을 출력하고 수정하려는 일정을 선택해서 객체로 가져옴
		Schedule schedule = selectSchedule("삭제");
		
		//잘못 선택하면
		if(schedule == null) {
			return;
		}
		list.remove(schedule);
		printBar();
		System.out.println("삭제가 완료 되었습니다.");
		
	}



	private void search() {
		if(list.size() == 0) {
			printBar();
			System.out.println("등록된 일정이 없습니다.");
			return;
		}
		list.stream().forEach(s->System.out.println(s));
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
	private List<Schedule> scheduleFilter(Predicate<Schedule> p){
		return list.stream().filter(p).collect(Collectors.toList());
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
	private void sort() {
		Collections.sort(list);
	}
	/**
	 * 날짜를 입력하여 입력한 날짜에 맞는 일정들을 출력하고,
	 * 출력된 일정을 선택하여 객체로 반환하는 메소드(재사용을 위해 만듬)
	 * @param 수정 또는 삭제
	 * @return 선택한 일정 객체
	 */
	private Schedule selectSchedule(String type) {
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
			scheduleFilter(s->s.getDateStr().substring(0, 10).equals(date));
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
