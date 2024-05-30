package day03;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12, 1, 2 : 겨울
		 * 그 외 : 잘못된 월
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		
		/* 월이 3,4,5이면 봄이라고 출력하고
		 * 아니면 월이 6,7,8이면 여름이라고 출력하고
		 * 아니면 월이 9,10,11이면 가을이라고 출력하고
		 * 아니면 월이 12,1,2이면 겨울이라고 출력하고 
		 * 아니면 잘못된 원이라고 출력
		 * 
		 * 월이 3이거나 월이 4이거나 월이 5이면 봄이라고 출력하고
		 * 아니면 월이 6이거나 월이 7이거나 월이 8이면 여름이라고 출력하고
		 * 아니면 월이 9이거나 월이 10이거나 월 11이면 가을이라고 출력하고
		 * 아니면 월이 12이거나 월이 1이거나 월이 2이면 겨울이라고 출력하고
		 * 아니면 잘못된 월이라고 출력
		 * */
		
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("봄");
		} 
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("여름");
		}
		else if(month == 9 || month == 10 || month == 11) {
			System.out.println("가을");
		}
		else if(month == 12 || month == 1 || month == 2) {
			System.out.println("겨울");
		}
		else {
			System.out.println("잘못된 월");
		}
		/* 월이 3이상이고 월이 5이하이면 봄이라고 출력하고
		 * 아니면 월이 6이상이고 월이 8이하이면 여름이라고 출력하고
		 * 아니면 월이 9이상이고 월이 11이하이면 가을이라고 출력하고
		 * 아니면 월이 12이거나 월이 1이상이고 2이하이면 겨울이라고 출력하고 
		 * 아니면 잘못된 월이라고 출력
		 * */
		if(month >= 3 && month <= 5) {
			System.out.println("봄");
		}
		else if(month >= 6 && month <= 8) {
			System.out.println("여름");
		}
		else if(month >= 9 && month <= 11) {
			System.out.println("가을");
		}
		else if(month == 12 || (month >= 1 && month <= 2)) {
			System.out.println("겨울");
		}
		else {
			System.out.println("잘못된 월");
		}
	}

}
