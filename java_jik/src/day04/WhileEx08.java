package day04;

public class WhileEx08 {

	public static void main(String[] args) {
		/* 두 정수 8과 12의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 최대 공약수 : 공약수 중 가장 큰 공약수
		 * 8 : 1, 2, 4, 8
		 * 12: 1, 2, 3, 4, 6, 12
		 * 8과 12의 공약수 : 1, 2, 4
		 * 8과 12의 최대 공약수 : 4
		 * 반복횟수 : i는 1부터 8까지 1씩 증가
		 * 규칙성 : 
		 * 		i가 8과 12의 약수이면 i를 gcd에 저장 
		 * 		=> i가 8의 약수이고 i가 12의 약수이면 i를 gcd에 저장
		 * 		=> 8을 i로 나누었을 때 나머지가 0과 같고 12를 i로 나누었을 때 나머지가 0과 같다면 i를 gcd에 저장
		 * 반복문 종료 후 : gcd를 출력
		 * */
		
		int gcd = 1;
		int i = 1;
		int num1 = 8, num2 = 12;
		while(i<=num1) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
			if(num1 % i == 0) {
				if(num2 % i == 0) {
					gcd = i;
				}
			}
			i++;
		}
		System.out.println(num1 + "과 " + num2 + "의 최대 공약수 : " + gcd);
	}

}
