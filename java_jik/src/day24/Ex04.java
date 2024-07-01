package day24;

public class Ex04 {

	public static void main(String[] args) {
		int score = 80;
		/* A를 판별하는 코드를 작성했는데, A가 아닌 경우에도 A가 출력
		 * 원인 : 잘못된 연산자 선택
		 * 해결방안 : ||를 &&로 수정
		 * */
		if(score >= 90 || score <= 100 ) {
			System.out.println("A");
		}

	}

}
