package day09;

import java.util.Scanner;

public class ConstructorEx01 {

	public static void main(String[] args) {
		
		
		/* Scanner : 클래스
		 * scan : 인스턴스, 객체
		 * new : 연산자
		 * Scanner(System.in) : 생성자 - InputStream이 필요한 생성자
		 * */
		Scanner scan1 = new Scanner(System.in);
		
		/* Scanner("...") : 생성자 - String(문자열)이 필요한 생성자
		 * */
		Scanner scan2 = new Scanner("abc\n123\n1.23");
		String str = scan2.next();
		int num = scan2.nextInt();
		double num2 = scan2.nextDouble();
		System.out.println(str);
		System.out.println(num);
		System.out.println(num2);
	}

}
