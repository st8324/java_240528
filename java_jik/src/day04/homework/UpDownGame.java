package day04.homework;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* 1~100사이의 랜덤한 수를 생성하여 해당 숫자를 맞추는 게임을 작성하세요.
		 * 예 (랜덤한 수가 30)
		 * 정수 입력 : 50
		 * DOWN!
		 * 정수 입력 : 20
		 * UP!
		 * 정수 입력 : 25
		 * UP!
		 * 정수 입력 : 30
		 * 정답입니다! 
		 * */
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.println("랜덤한 수 : " + random);
		do {
			//정수 입력 : 이라는 안내 문구 출력 
			System.out.print("정수 입력 : ");
			//정수를 입력 
			num = scan.nextInt();
			//DOWN인지 UP인지 정답인지를 판별
			/* num가 random보다 크다면 DOWN!으로 출력하고
			 * 아니면 num가 random보다 작으면 UP!으로 출력하고
			 * 아니면 정답입니다라고 출력
			 * */
			if(num > random) {
				System.out.println("DOWN!");
			}
			else if(num < random) {
				System.out.println("UP!");
			}
			else {
				System.out.println("정답입니다!");
			}
		}while(random != num);
	}
}





