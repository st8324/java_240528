package day04;

public class WhileEx02 {

	public static void main(String[] args) {
		/* 1부터 5까지 콘솔에 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : i를 출력
		 * 반복문 종료 후: 없음
		 * */
		
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
		/* 10부터 1까지 콘솔에 출력하는 코드를 작성하세요. 
		 * 반복횟수 : i는 10부터 1까지 1씩 감소
		 * 규칙성 : i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		System.out.println("------");
		i = 10;
		while(i >= 1) {
			System.out.println(i);
			i--;
		}
	}

}
