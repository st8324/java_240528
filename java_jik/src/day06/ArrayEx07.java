package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		/* UpDown 게임에 다음 기능을 추가하세요.
		 * - 기록은 최대 5개
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * (랜덤이 35라고 가정)
		 * 정수 입력 : 50
		 * DOWN!
		 * 정수 입력 : 30
		 * UP!
		 * 정수 입력 : 35
		 * 정답입니다.
		 * 맞힌 횟수는 3회입니다.
		 * 기록이 등록됩니다.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 기록확인
		 * 1. 3회
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * 프로그램을 종료합니다.
		 * */

		//변수 선언 
		Scanner scan = new Scanner(System.in);
		int menu, min = 1, max = 100, random, num, count;
		int [] record = new int[5];
		int recordCount = 0, i;
		//선택한 메뉴가 3이 아닐때 실행되는 반복문
		do {
			//메뉴 출력
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			//Scanner를 이용하여 메뉴를 입력 
			menu = scan.nextInt();
			
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			//선택한 메뉴가 1이면 플레이 문구 출력 하는 코드 작성(게임 플레이하는 코드 작성)
			case 1:
				//1~100사이의 랜덤한 수를 생성
				random = (int)(Math.random() * (max - min + 1) + min);
				System.out.println(random);
				//횟수를 초기화
				count = 0;
				//입력한 값이 랜덤한 수와 같지 않으면 반복
				do {
					//정수 입력 : 안내문구 출력
					System.out.print("정수 입력 : ");
					//Scanner를 이용하여 정수를 입력
					num = scan.nextInt();
					//입력한 횟수를 증가
					count++;
					//입력한 값이 랜덤한 값보다 크면 DOWN이라고 출력하고
					if(num > random) {
						System.out.println("DOWN");
					}
					//입력한 값이 랜덤한 값보다 작으면 UP이라고 출력하고
					else if(num < random) {
						System.out.println("UP");
					}
					//같으면 정답입니다를 출력하고 입력한 횟수를 출력
					else {
						System.out.println("정답입니다.");
						System.out.println("맞힌 횟수는 " + count + "회 입니다.");
					}
				}while(random != num);
				
				//기록의 개수가 5개 미만이면 
				if(recordCount < record.length) {
					//기록을 등록
					//recordCount번지에 저장하고 recordCount를 1증가
					record[recordCount] = count;
					recordCount++;
				}
				//아니면 내 기록이 5등보다 좋은지 비교해서 좋으면
				else if(record[recordCount - 1] > count){
					//기록을 등록
					//마지막번지에 내 기록을 등록
					record[recordCount - 1] = count;
				}
				//기록 정렬
				//Arrays.sort를 이용하여 0번지부터 recordCount번지전까지 정렬
				//0번지는 포함, recordCount번지는 포함을 안하고 앞 번지까지
				Arrays.sort(record, 0, recordCount);
				break;
			//선택한 메뉴가 2이면 기록 확인 문구 출력하는 코드 작성(기록 확인하는 코드 작성)
			case 2:
				if(recordCount == 0) {
					System.out.println("등록된 기록이 없습니다.");
					break;
				}
				//record에 있는 기록들을 recordCount개만큼 순서대로 출력
				/* 반복횟수 : i는 0부터 recordCount보다 작을 때까지 1씩 증가
				 * 규칙성 : i+1. 횟수를 출력
				 * 반복문 종료 후 : 없음
				 * */
				for(i = 0; i < recordCount; i++) {
					System.out.println(i+1 + ". " + record[i] + "회");
				}
				break;
			//선택한 메뉴가 3이면 프로그램 종료 문구 출력하는 코드 작성
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			//아니면 잘못된 메뉴 문구 출력하는 코드 작성
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 3);
	}

}





