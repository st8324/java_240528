package day04;

public class WhileEx07 {

	public static void main(String[] args) {
		/* 4가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 1과 자기자신인 수를 소수라고 함
		 * 1 : 소수가 아님
		 * 2 : 소수
		 * 3 : 소수
		 * 4 : 소수가 아님
		 * 반복횟수 : i는 1부터 4까지 1씩 증가
		 * 규칙성 : i가 4의 약수이면 약수의 개수(count)를 1증가
		 * 반복문 종료 후 : 약수의 개수가 2개이면 소수, 아니면 소수가 아님이라고 출력
		 * */
		int num = 121;
		int i = 1;
		int count = 0;
		while(i <= num) {
			if(num % i == 0) {
				count++;
			}
			i++;
		}
		if(count == 2) {
			System.out.println(num + "는 소수");
		}
		else {
			System.out.println(num + "는 소수가 아님");
		}
	}

}
