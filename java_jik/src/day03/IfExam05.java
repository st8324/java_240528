package day03;

import java.util.Scanner;

public class IfExam05 {

	public static void main(String[] args) {
		/* IfExam05 클래스를 생성하세요.
		 * 정수를 입력 받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성하세요.
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		/* num가 6의 배수이면 6의 배수라고 출력하고
		 * 아니면 num가 2의 배수이면 2의 배수라고 출력하고
		 * 아니면 num가 3의 배수이면 3의 배수라고 출력하고
		 * 아니면 2,3,6의 배수가 아닙니다라고 출력
		 * */
		if(num % 6 == 0) {
			System.out.println(num + "는 6의 배수입니다.");
		}
		else if(num % 2 == 0) {
			System.out.println(num + "는 2의 배수입니다.");
		} 
		else if(num % 3 == 0) {
			System.out.println(num + "는 3의 배수입니다.");
		}
		else {
			System.out.println("2,3,6의 배수가 아닙니다.");
		}
		
		/* num가 2의 배수이고 3의 배수가 아니면 2의 배수라고 출력하고
		 * 아니면 num가 3의 배수이고 2의 배수가 아니면 3의 배수라고 출력하고
		 * 아니면 num가 6의 배수이면 6의 배수라고 출력하고
		 * 아니면 2,3,6의 배수가 아닙니다라고 출력
		 * */
		if(num % 2 == 0 && num % 3 != 0) {
			System.out.println(num + "는 2의 배수입니다.");
		}
		else if(num % 3 == 0 && num % 2 != 0) {
			System.out.println(num + "는 3의 배수입니다.");
		}
		else if(num % 6 == 0) {
			System.out.println(num + "는 6의 배수입니다.");
		}
		else {
			System.out.println("2,3,6의 배수가 아닙니다.");
		}
		
	}

}
