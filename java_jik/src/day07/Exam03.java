package day07;

import java.util.Scanner;

public class Exam03 {
	
	public static void main(String[] args) {
		/* 입력한 문자열이 배열에 있는지 없는지 확인하는 코드를 작성하세요.
		 * 단어 입력 (종료:-1) : apple 
		 * 없는 단어입니다.
		 * 단어 입력 (종료:-1) : cat
		 * 있는 단어입니다.
		 * 단어 입력 (종료:-1) : -1
		 * 종료합니다.
		 * */
		String [] list = new String[] {"cat", "dog", "banana"};
		String word;
		Scanner scan = new Scanner(System.in);
		boolean result;
		while(true) {
			//안내문구 출력
			System.out.print("단어 입력 (종료:-1) : ");
			//단어를 입력
			word = scan.next();
			//단어가 -1이면 종료합니다 출력 후 반복문 종료
			if(word.equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}
			result = false;//없다로 초기화
			//리스트에 단어가 있는지 확인
			for(String tmp : list) {
				if(word.equals(tmp)) {
					result = true;
					break;
				}
			}
			
			//있으면 있다고 출력, 없으면 없다고 출력
			if(result) {
				System.out.println("있는 단어입니다.");
			}
			else {
				System.out.println("없는 단어입니다.");
			}
		}
	}

}
