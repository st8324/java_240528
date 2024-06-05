package day06;

import java.util.Scanner;

public class ArrayEx08 {

	public static void main(String[] args) {
		/* 문자열을 최대 5개 저장할 수 있는 배열을 선언하고, 
		 * 문자열을 5개 입력하여 저장 한 후, 저장한 문자열을 출력하는 
		 * 예제를 작성하세요.
		 * */
		String [] list = new String [5];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < list.length; i++) {
			System.out.print("문자열 입력 : ");
			list[i] = scan.next();
		}
		for(String tmp : list) {
			System.out.println(tmp);
		}
	}

}
