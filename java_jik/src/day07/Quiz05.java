package day07;

public class Quiz05 {

	public static void main(String[] args) {
		//다음 코드가 실행 됐을 때 콘솔창에 출력될 결과를 메모장에 작성하세요.
		//해당 코드를 입력해서 실행하지 말고, 메모장에 작성해보세요.
		int i;
		i = 1; 
		while(i <= 10) {
			if(i % 2 == 0); {
				System.out.println("i = " + i);
			}
			/*if( i % 2 == 0) {
				
			}
			System.out.println("i = " + i);
			*/
			i++;
		}
		/* 결과
		 * i = 1
		 * i = 2
		 * ...
		 * i = 10
		 */
	}
}
