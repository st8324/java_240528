package day12;

import java.util.Random;

public class RandomEx01 {

	public static void main(String[] args) {

		Random r1 = new Random(10);//seed값을 10으로 하면 프로그램을 재실행해도 랜덤한 수 패턴이 동일
		
		for(int i = 0; i<100; i++) {
			int num = r1.nextInt(10);//0~9사이 랜덤
			System.out.print(num + " " + (i % 30 == 29?"\n":""));
		}
		
		Random r2 = new Random();//현재 시간을 seed값으로 활용하면 매번 실행마다 다른 패턴의 랜덤수를 생성할 수 있다
		System.out.println();
		System.out.println("==================");
		
		for(int i = 0; i<100; i++) {
			int num = r2.nextInt(10);//0~9사이 랜덤
			System.out.print(num + " " + (i % 30 == 29?"\n":""));
		}

	}

}
