package day13;

import java.util.Scanner;

public class ExceptionEx01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		try {
			/* 예외처리를 하지 않으면 예외가 발생했을 때 프로그램이 중단된다
			 * 예외처리를 하면 예외처리를 실행 후 프로그램을 이어서 실행한다 */
			System.out.println(num1 / num2);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 번지에 접근했습니다.");
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		catch(RuntimeException e) {
			System.out.println("실행 예외가 발생했습니다.");
		}
		catch(Exception e) {
			System.out.println("예외가 발생했습니다.");
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
