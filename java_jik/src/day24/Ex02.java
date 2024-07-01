package day24;

public class Ex02 {

	public static void main(String[] args) {
		
		int num1 = 1, num2 = 2;
		
		double res = num1 / /*(double)*/num2;
		/* 1 / 2 = 0.5가 출력되지 않음
		 * 원인 : 정수 나누기 정수 => 정수이기 때문에 0을 실수로 저장해봐야 0.0이 됨
		 * 해결 방법 : num1이나 num2를 실수로 자료형변환을 해야 함
		 * */
		System.out.println(num1 + " / " + num2 + " = " + res);

	}

}
