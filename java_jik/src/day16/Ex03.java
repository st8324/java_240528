package day16;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ex03 {

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
		Map<String, Integer> map = new HashMap<String, Integer>();
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 따른 기능 실행
			runMenu(menu, map);
		}while(menu != 3);
		
	}

	private static void runMenu(int menu, Map<String, Integer> map) {
		switch (menu) {
		case 1:
			int count = play();
			record(map, count);
			break;
		case 2:
			printRecord(map);
			break;
		case 3:
			System.out.println("프로그램 종료.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

	private static void printRecord(Map<String, Integer> map) {
		//기록이 없으면 등록된 기록이 없습니다라고 출력하고 종료
		if(map.size() == 0) {
			System.out.println("등록된 기록이 없습니다.");
			return;
		}
		//반복문을 이용하여 등수. 아이디 횟수회 형태로 출력
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String id = it.next();
			Integer count = map.get(id);
			System.out.println(id + " " + count + "회");
		}
	}

	private static void record(Map<String, Integer> map, int count) {
		final int MAX_RECORD_COUNT = 5;
		//저장된 기록이 5명 미만이면 
		if( map.size() < MAX_RECORD_COUNT) {
			//아이디를 입력 받고
			System.out.println("ID : ");
			String id = scan.next();
			
			//map에 아이디와 횟수를 추가하는데 기존 기록이 있는 경우 더 좋은 기록으로 저장
			recordUser(map, id, count);
			
			//종료
			return;
		}
		//5등 기록과 내 기록을 비교해서 내 기록이 좋으면
		String deleteId = checkRecord(map, count);
		if(deleteId != null) {
			//아이디를 입력 받고
			System.out.println("ID : ");
			String id = scan.next();
			
			//deleteId와 id가 같지 않으면 deleteId에 있는 기록을 삭제 
			if(!contains(map, id)) {
				map.remove(deleteId);
			}
			//recordUser를 실행
			recordUser(map, id, count);
		}
	}

	private static boolean contains(Map<String, Integer> map, String id) {
		return map.get(id) != null;
	}

	private static String checkRecord(Map<String, Integer> map, int count) {
		Iterator<String> it = map.keySet().iterator();
		String deleteId = null;
		int maxCount = 0;
		while(it.hasNext()) {
			String id = it.next();
			Integer recordCount = map.get(id);
			//현재 기록이 저장된 기록보다 좋고 저장된 기록이 삭제할 기록보다 크면
			if(count < recordCount && maxCount < recordCount) {
				maxCount = recordCount;
				deleteId = id;
			}
		}
		return deleteId;
	}

	private static void recordUser(Map<String, Integer> map, String id, int count) {
		Integer oldCount = map.get(id);
		//이전 기록이 없거나 이전 기록보다 지금 기록이 좋으면 추가
		if(oldCount == null || count < oldCount) {
			map.put(id, count);
		}
	}

	private static int play() {
		int min = 1, max = 100;
		int random = Ex01.random(min, max);
		
		System.out.println(random);
		
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