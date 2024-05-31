package day04;

import java.util.Scanner;

public class BreakEx01 {

	public static void main(String[] args) {
		//y를 입력하면 중지하는 코드를 작성하세요.
		
		char ch;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("문자 입력 : ");
			ch = scan.next().charAt(0);
			//ch의 값이 y이면 반복문 종료
			if(ch == 'y') {
				break;
			}
		}

	}

}
