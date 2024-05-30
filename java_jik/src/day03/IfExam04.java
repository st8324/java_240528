package day03;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		/* IfExam04 클래스를 생성하세요.
		 * 정수를 입력 받아 3의 배수인지 아닌지 판별하는 코드를 작성하세요.
		 * 예1:
		 * 정수 입력 : 6
		 * 3의 배수입니다.
		 * 예2:
		 * 정수 입력 : 2
		 * 3의 배수가 아닙니다.
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		//num가 3의 배수이면 3의 배수라고 출력하고
		//num를 3으로 나누었을 때 나머지가 0과 같다면 3의 배수라고 출력하고
		if(num % 3 == 0) {
			System.out.println(num +"는 3의 배수입니다.");
		}
		//아니면 3의 배수가 아닙니다 라고 출력
		else {
			System.out.println(num +"는 3의 배수가 아닙니다.");
		}
	}

}
