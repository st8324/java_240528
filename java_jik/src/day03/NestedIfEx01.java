package day03;

public class NestedIfEx01 {

	public static void main(String[] args) {
		/* 6의 배수를 중첩 if문을 이용하여 작성하는 예제 */
		int num = 12;
		
		if(num % 6 == 0) {
			System.out.println("6의 배수입니다.");
		}
		else {
			System.out.println("6의 배수가 아닙니다.");
		}
		
		if(num % 2 == 0 && num % 3 == 0) {
			System.out.println("6의 배수입니다.");
		}
		else {
			System.out.println("6의 배수가 아닙니다.");
		}
		
		//중첩 if문
		if(num % 2 == 0) {
			if(num % 3 == 0) {
				System.out.println("6의 배수입니다.");
			}
			else {
				System.out.println("6의 배수가 아닙니다.");
			}
		}
		else {
			System.out.println("6의 배수가 아닙니다.");
		}
	}

}
