package day03;

import java.util.Scanner;

public class NestedIfEx02 {

	public static void main(String[] args) {
		/* IfExam03 클래스를 생성하세요.
		 * 산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요.
		 * 예:
		 * 두 정수와 산술 연산자를 입력하세요(예 : 1 + 2 ) : 1 + 2 [엔터]
		 * 1 + 2 = 3
		 */
		
		//Scanner를 이용하여 두 정수와 산술 연산자를 입력
		//산술 연산자를 문자로 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2 ) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		
		/* 연산자가 + 이면 두 정수의 합을 출력하고
		 * 아니면 연산자가 -이면 두 정수의 차를 출력하고
		 * 아니면 연산자가 *이면 두 정수의 곱을 출력하고
		 * 아니면 연산자가 /이면 두 정수의 나눈 결과를 출력하고
		 * 아니면 연산자가 %이면 두 정수의 나머지 결과를 출력하고
		 * 아니면 잘못된 연산자입니다라고 출력
		 * */
		double result;
		if(operator == '+') {
			result = num1 + num2;
			System.out.println("" + num1 + operator + num2 + "="+(int)result);
		}
		else if(operator == '-') {
			result = num1 - num2;
			System.out.println("" + num1 + operator + num2 + "="+(int)result);
		}
		else if(operator == '*') {
			result = num1 * num2;
			System.out.println("" + num1 + operator + num2 + "="+(int)result);
		}
		//num2가 0이면 0으로 나눌수 없습니다고 출력
		else if(operator == '/') {
			if(num2 != 0) {
				result = (double)num1 / num2;
				System.out.println("" + num1 + operator + num2 + "="+result);
			}
			else {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		}
		//num2가 0이면 0으로 나눌수 없습니다고 출력
		else if(operator == '%') {
			if(num2 != 0) {
				result = num1 % num2;
				System.out.println("" + num1 + operator + num2 + "="+(int)result);
			}
			else {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		}
		else {
			System.out.println(operator + "는 산술 연산자가 아닙니다.");
		}

	}

}
