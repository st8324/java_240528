package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex02 {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* UP DOWN 게임에 기록을 저장하는 기능을 추가
		 * - 최대 5등까지 저장하며, 먼저 등록된 순으로 저장
		 * - 아이디를 입력받아 저장
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 * */
		int menu;
		List<Record> list = new ArrayList<Record>();
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 따른 기능 실행
			runMenu(menu, list);
		}while(menu != 3);
		
	}

	private static void runMenu(int menu, List<Record> list) {
		switch (menu) {
		case 1:
			int count = play();
			record(list, count);
			break;
		case 2:
			printRecord(list);
			break;
		case 3:
			System.out.println("프로그램 종료.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

	private static void printRecord(List<Record> list) {
		//기록이 없으면 등록된 기록이 없습니다라고 출력하고 종료
		if(list.size() == 0) {
			System.out.println("등록된 기록이 없습니다.");
			return;
		}
		//반복문을 이용하여 등수. 아이디 횟수회 형태로 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 +". " + list.get(i));
		}
	}

	private static void record(List<Record> list, int count) {
		//저장된 기록이 5명 미만이면 
		if( list.size() < 5) {
			//아이디를 입력 받고
			System.out.println("ID : ");
			String id = scan.next();
			//아이디와 횟수를 이용해서 객체를 생성
			Record record = new Record(count, id); 
			//리스트에 생성된 객체를 추가
			list.add(record);
			//Collections.sort를 이용하여 정렬
			Collections.sort(list);
			//종료
			return;
		}
		//5등 기록과 내 기록을 비교해서 내 기록이 좋으면
		final int MAX_RECORD_COUNT = 5;
		if(count < list.get(MAX_RECORD_COUNT - 1).getCount()) {
			//아이디를 입력 받고
			System.out.println("ID : ");
			String id = scan.next();
			//아이디와 횟수를 이용해서 객체를 생성
			Record record = new Record(count, id); 
			//5등 위치에 내 기록(생성된 객체)을 저장
			list.set(MAX_RECORD_COUNT - 1,record);
			//Collections.sort를 이용하여 정렬
			Collections.sort(list);
		}
	}

	private static int play() {
		int min = 1, max = 100;
		int random = Ex01.random(min, max);
		
		//System.out.println(random);
		
		int num, count = 0;
		do {
			System.out.print("입력 : ");
			num = scan.nextInt();
			Ex01.printResult(random, num);
			count++;
		}while(random != num);
		return count;
	}

	private static void printMenu() {
		System.out.print(
				  "메뉴\r\n"
				+ "1. 플레이\r\n"
				+ "2. 기록확인\r\n"
				+ "3. 종료\r\n"
				+ "메뉴 선택 : ");
	}
}
@Data
@AllArgsConstructor
class Record implements Comparable<Record>{
	
	private int count;
	private String ID;
	
	@Override
	public int compareTo(Record o) {
		return count - o.count;
	}

	@Override
	public String toString() {
		return ID + " " + count + "회";
	}
	
}
