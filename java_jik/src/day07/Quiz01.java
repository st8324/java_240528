package day07;

public class Quiz01 {

	public static void main(String[] args) {
		//다음 코드가 실행 됐을 때 콘솔창에 출력될 결과를 메모장에 작성하세요.
		//해당 코드를 입력해서 실행하지 말고, 메모장에 작성해보세요.
		int i;
		for(i = 0; i<5; i++) {
			System.out.println("반복문 실행 중 i = " + i);
		}
		//반복문이 종료 됐을 때 i의 값을 예상할 수 있는지
		System.out.println("반복문 종료 후 i = " + i);
		/* 결과 
		 * 반복문 실행 중 i = 0
		 * 반복문 실행 중 i = 1
		 * 반복문 실행 중 i = 2
		 * 반복문 실행 중 i = 3
		 * 반복문 실행 중 i = 4
		 * 반복문 종료 후 i = 5
		 * 
		 * */
	}

}
