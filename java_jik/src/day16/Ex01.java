package day16;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* Up Down 게임 예제를 구현하세요. 
		 * 랜덤으로 숫자를 만들고(1~100) 만들어진 숫자를 맞추는 게임
		 * 랜덤 : 33
		 * 입력 : 50
		 * DOWN!
		 * 입력 : 25 
		 * UP!
		 * 입력 : 33
		 * 정답!
		 * */
		int min = 1, max = 100;
		int random = random(min, max);
		
		System.out.println(random);
		
		int num;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("입력 : ");
			num = scan.nextInt();
			printResult(random, num);
		}while(random != num);
	}

	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1 ) + min);
	}
	
	public static void printResult(int random, int num) {
		if(random > num) {
			System.out.println("UP!");
		}
		else if(random < num) {
			System.out.println("DOWN!");
		}
		else {
			System.out.println("정답!");
		}
	}

}



