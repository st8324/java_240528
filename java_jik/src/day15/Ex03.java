package day15;

import java.util.HashSet;
import java.util.Random;

public class Ex03 {

	public static void main(String[] args) {
		/* 1~10사이의 랜덤한 수 6개를 중복되지 않게 생성해서 저장하고 출력하는 코드를 작성하세요. 
		 * set을 활용
		 * size() */
		
		HashSet<Integer> set = new HashSet<Integer>();
		int min = 1, max = 10;
		
		while(set.size() < 6) {
			int r = (int)(Math.random()*(max - min + 1) + min);
			/*
			Random random = new Random();
			int r = random.nextInt(min, max+1);
			*/
			set.add(r);
		}
		System.out.println(set);
	}

}
