package day04;

public class WhileEx06 {

	public static void main(String[] args) {
		/* 12의 약수를 출력하는 코드를 작성하세요.
		 * 약수는 나누어서 나머지가 0이 되게 하는 수 
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 반복횟수 : i는 1부터 12까지 1씩 증가
		 * 규칙성 : i가 12의 약수이면 i를 출력
		 * 		 =>12를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		
		int i = 1;
		int num = 9;
		System.out.print(num + "의 약수 : ");
		while(i <= num) {
			if(num % i == 0) {
				System.out.print(i + (i != num ? ", " : "\n"));
			}
			i++;
		}
	}

}
