package day04;

public class NestedForEx01 {

	public static void main(String[] args) {
		/* 구구단 2~9단을 출력하는 코드를 작성하세요.
		 * 반복횟수 : num를 2부터 9까지 1씩 증가
		 * 규칙성 : num단 출력하는 코드
		 * 반복문 종료 후 : 없음
		 * */

		int num = 3;
		for(num = 2; num <= 9; num++) {
			//num단 출력
			System.out.println(num + "단");
			for(int i = 1; i<= 9; i++) {
				System.out.println(num + " X " + i + " = " + num * i);
			}
		}
		
	}

}
