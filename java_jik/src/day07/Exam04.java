package day07;

import java.util.Arrays;
import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/* Exam01~03 기능을 하나로 합쳐서 다음 기능을 구현하세요.
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * -----------
		 * 단어 입력 (종료:-1) : abc
		 * 단어를 추가했습니다. / 단어를 추가하지 못했습니다.
		 * 단어 입력 (종료:-1) : -1
		 * 메뉴로 돌아갑니다.
		 * -----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * -----------
		 * 단어 입력 (종료:-1) : abc
		 * 있는 단어입니다. / 없는 단어입니다.
		 * 단어 입력 (종료:-1) : -1
		 * 메뉴로 돌아갑니다.
		 * -----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 0
		 * -----------
		 * 잘못된 메뉴입니다.
		 * -----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * -----------
		 * 프로그램을 종료합니다.
		 * -----------
		 * */
		Scanner scan = new Scanner(System.in);
		int menu;
		String [] list = new String[2];
		
		String word;//추가/검색 기능에서 입력할 단어를 저장하는 변수
		int count = 0; // 추가된 단어의 개수
		boolean result; //검색할 때 있다 없다를 확인할 변수
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();

			switch(menu) {
			case 1:
				System.out.println("-----------");
				while(true) {
					System.out.print("단어 입력 (종료:-1) : ");
					word = scan.next();
					
					//입력된 단어가 -1이이면 종료합니다 문구 출력 후 반복문을 종료
					if(word.equals("-1")) {
						System.out.println("종료합니다.");
						break;
					}
					//list가 꽉 찼으면 추가하지 못했다고 알림
					//저장된 갯수가 배열의 크기와 같다면
					if(count == list.length) {
						System.out.println("단어를 추가하지 못했습니다.");
					}
					//아니면 추가하고 추가했다고 알림
					else {
						list[count] = word;
						count++;
						System.out.println("단어를 추가했습니다. ");
					}
				}
				System.out.println("-----------");
				break;
			case 2:
				System.out.println("-----------");
				while(true) {
					//안내문구 출력
					System.out.print("단어 입력 (종료:-1) : ");
					//단어를 입력
					word = scan.next();
					//단어가 -1이면 종료합니다 출력 후 반복문 종료
					if(word.equals("-1")) {
						System.out.println("종료합니다.");
						break;
					}
					result = false;//없다로 초기화
					//리스트에 단어가 있는지 확인
					for(int i = 0; i<count; i++) {
						String tmp = list[i];
						if(word.equals(tmp)) {
							result = true;
							break;
						}
					}
					
					//있으면 있다고 출력, 없으면 없다고 출력
					if(result) {
						System.out.println("있는 단어입니다.");
					}
					else {
						System.out.println("없는 단어입니다.");
					}
				}
				System.out.println("-----------");
				break;
			case 3:
				System.out.println("-----------");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("-----------");
				break;
			default:
				System.out.println("-----------");
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("-----------");
				break;
			}

		}while(menu != 3);
	}

}
