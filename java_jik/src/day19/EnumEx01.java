package day19;

import java.util.Scanner;

public class EnumEx01 {

	public static void main(String[] args) {
		/* 열거형 : 상수 데이터들의 집합
		 * enum을 이용하여 생성
		 * 
		 * 열거형 정의(기본)
		 * enum 열거형명{
		 * 		값1,
		 * 		값2,
		 * 		...
		 * }
		 * 
		 * 열거형 사용
		 * 열거형명 객체명 = 열거형.값;
		 * 
		 * 열거형.valueOf(문자열) : 입력한 문자열과 같은 열거형 값이 있으면 해당 객체로 리턴하고 없으면 예외 발생
		 * */
		System.out.print("계절을 입력하세요(봄:SPRING, 여름:WINTER, 가을:FALL, 겨울:WINTER) : ");
		Scanner scan = new Scanner(System.in);
		String season = scan.next();
		Season s = Season.valueOf(season);
		switch (s) {
		case SPRING: 
			System.out.println("봄입니다.");
			break;
		case SUMMER:
			System.out.println("여름입니다.");
			break;
		case FALL:
			System.out.println("가을입니다");
			break;
		case WINTER:
			System.out.println("겨울입니다.");
			break;
		}
		
		System.out.print("계절을 입력하세요(봄:1, 여름:2, 가을:3, 겨울:4) : ");
		int num = scan.nextInt();
		s = null;
		/* 열거형.values() : 열거형 객체 안엤는 모든 상수들을 배열로 반환
		 * 열거형.ordinal() : 열거형 객체의 순서로 0부터 시작
		 * */
		for(Season tmp : Season.values()) {
			if(num == tmp.ordinal() + 1) {
				s = tmp;
			}
		}
		switch (s) {
		case SPRING: 
			System.out.println("봄입니다.");
			break;
		case SUMMER:
			System.out.println("여름입니다.");
			break;
		case FALL:
			System.out.println("가을입니다");
			break;
		case WINTER:
			System.out.println("겨울입니다.");
			break;
		}
	}
}
enum Season{
	SPRING,
	SUMMER,
	FALL,
	WINTER
}

