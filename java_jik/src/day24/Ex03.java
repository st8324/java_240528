package day24;

public class Ex03 {

	public static void main(String[] args) {
		int num = 2;
		/* 짝수라고 판별해야 하는데 짝수, 홀수 모두 출력이 됨
		 * 원인 : ; 때문에 각 if문의 실행문이 없음
		 * 해결방법 : ;를 제거
		 * */
		if(num % 2 == 0); {
			System.out.println("짝수");
		}
		
		if(num % 2 != 0); {
			System.out.println("홀수");
		}

	}

}
