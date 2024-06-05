package day07;

import java.util.Arrays;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수 3개를 배열에 저장하는데,
		 * 중복되지 않게 저장하는 코드를 작성해보세요.
		 * */
		int [] list = new int[3];
		int count = 0; //저장된 숫자의 개수
		int min = 1, max = 9;
		int random, i;
		/* 반복횟수 : 저장된 숫자가 3개가 아닐 때 반복 => 저장된 숫자가 3보다 작을 때
		 * 규칙성 : 랜덤한 수를 생성해서 중복되지 않으면 저장
		 * 반복문 종료 후 : 배열에 저장된 숫자 출력
		 * */
		while(count < 3) {
			//랜덤한 수를 생성하여 변수에 저장
			random = (int)(Math.random() * (max - min + 1) + min);
			//배열에 랜덤한 수가 있는지 확인
			/* 반복횟수 : i는 0부터 저장된 개수보다 작을 때까지 1씩 증가
			 * 규칙성 : i번지에 있는 값과 랜덤한 수가 같으면 반복문을 종료
			 * 반복문 종료 후 : 없음
			 * */
			for(i = 0; i < count; i++) {
				if(list[i] == random) {
					break;//break를 만나면 i는 count보다 작을수밖에 없음
				}
			}
			//없으면 배열에 추가한 후 저장된 개수를 1증가
			//=> i와 count가 같다면 배열 ?번지에 랜덤한 수를 저장한 후 저장된 개수를 1증가
			if(i == count) {
				list[count] = random;
				count++;
			}
		}
		System.out.println(Arrays.toString(list));
	}

}
