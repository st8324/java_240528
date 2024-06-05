package day07;

public class Quiz08 {

	public static void main(String[] args) {
		//다음 코드가 실행 됐을 때 콘솔창에 출력될 결과를 메모장에 작성하세요.
		//해당 코드를 입력해서 실행하지 말고, 메모장에 작성해보세요.
		int i;
		int [] arr = new int [] {1,2,3,4,5};
		for(i = 0; i<=arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
		/* 결과
		 * 0 : 1
		 * 1 : 2
		 * 2 : 3
		 * 3 : 4
		 * 4 : 5
		 * 예외 발생
		 * */
	}
}
