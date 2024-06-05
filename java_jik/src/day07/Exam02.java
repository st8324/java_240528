package day07;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/* 최대 단어 2개를 저장할 수 있는 배열을 이용하여
		 * 원하는 단어를 입력하면 단어를 배열에 추가하는 코드를 작성하세요.
		 * 예시)
		 * 단어입력 (종료:-1) : cat
		 * 단어를 추가했습니다.
		 * 단어입력 (종료:-1) : dog
		 * 단어를 추가했습니다. 
		 * 단어입력 (종료:-1) : good
		 * 단어를 추가하지 못했습니다.
		 * 단어입력 (종료:-1) : -1
		 * 종료합니다.
		 * */
		String [] list = new String[2];
		Scanner scan = new Scanner(System.in);
		String tmp;
		int count = 0;//저장된 단어의 갯수
		while(true) {
			System.out.print("단어 입력 (종료:-1) : ");
			tmp = scan.next();
			
			//입력된 단어가 -1이이면 종료합니다 문구 출력 후 반복문을 종료
			if(tmp.equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}
			//list가 꽉 찼으면 추가하지 못했다고 알림
			//저장된 갯수가 배열의 크기와 같다면
			if(count == list.length) {
				System.out.println("단어를 추가하지 못했습니다.");
			}
			//아니면 추가하고 추가했다고 알림
			else {
				list[count] = tmp;
				count++;
				System.out.println("단어를 추가했습니다. ");
			}
		}
	}

}
