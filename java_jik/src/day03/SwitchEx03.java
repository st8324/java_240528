package day03;

import java.util.Scanner;

public class SwitchEx03 {
	
	public static void main(String[] args) {
		/* 산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요.(switch문으로)
		 * 예:
		 * 두 정수와 산술 연산자를 입력하세요(예 : 1 + 2 ) : 1 + 2 [엔터]
		 * 1 + 2 = 3
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2 ) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		switch(operator) {
		case '+':	
			System.out.println("" + num1 + operator + num2 + "="+(num1 + num2));
			break;
		case '-':	
			System.out.println("" + num1 + operator + num2 + "="+(num1 - num2));
			break;
		case '*':	
			System.out.println("" + num1 + operator + num2 + "="+(num1 * num2));
			break;
		case '%':	
			System.out.println("" + num1 + operator + num2 + "="+(num1 % num2));
			break;
		case '/':	
			System.out.println("" + num1 + operator + num2 + "="+(num1 / (double)num2));
			break;
		default:
			System.out.println(operator + "는 산술 연산자가 아닙니다.");
		}
	}
}





