package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		String [] list = {"dog", "cat", "java", "cup", "computer"};
		
		//문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는 코드를 작성하세요.
		/* 예시1
		 * 찾을 문자열 입력 : cat
		 * cat가 있습니다.
		 * 
		 * 예시2
		 * 찾을 문자열 입력 : abc
		 * abc가 없습니다.
		 * */
		//찾을 문자열 입력 : 문구를 콘솔에 출력 
		System.out.print("찾을 문자열 입력 : ");
		//단어를 입력
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		
		//입력받은 단어가 있는지 없는지 찾아서 결과를 콘솔에 출력
		//1. list에서 입력받은 단어가 있는지 없는지 하나씩 탐색해서 찾음
		//1-1. 단어가 있는지 없는지 확인하기 위한 변수를 선언
		boolean result = false;
		//1-2. list에서 하나씩 꺼내서 입력받은 단어와 같은지 비교하여 같으면 변수를 있다로 만들고 빠져나옴
		for(String tmp : list) {
			if(word.equals(tmp)) {
				result = true;
				break;
			}
		}
		for(int i = 0; i<list.length; i++) {
			String tmp = list[i];
			if(word.equals(tmp)) {
				result = true;
				break;
			}
		}
		//2. 있으면 있습니다. 아니면 없습니다라고 콘솔에 출력
		if(result) {
			System.out.println(word + "가 있습니다.");
		}
		else {
			System.out.println(word + "가 없습니다.");
		}
	}
}
