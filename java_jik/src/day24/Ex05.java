package day24;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		/* 문자열을 입력받아 exit가 아니면 입력한 문자열을 출력하고, exit이면 종료하는 코드를
		 * 작성하려고 했다.
		 * 원인 : 
		 * 1. res가 fasle이어서 한번도 실행이 안됨
		 * 2. 문자열을 ==로 비교함
		 * 3. continue (while문에서 조건식으로 이동)
		 * 해결방법 : 
		 * 1. res를 true로 수정
		 * 2. ==를 equals로 수정
		 * 3. continue를 break로 수정
		 * */
		Scanner scan = new Scanner(System.in);
		boolean res = false;
		while(res) {
			System.out.print("문자열 입력 : ");
			String str = scan.next();
			if(str == "exit") {
				continue;
			}
			System.out.println(str);
		}

	}

}
