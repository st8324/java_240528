package day04;

public class BreakEx02 {

	public static void main(String[] args) {
		//최대 공약수 예제를 break문을 이용하여 구현하는 예제
		/* num1에 8, num2에 12가 저장되어 있고
		 * num1과 num2의 최대 공약수를 다음과 같이 구하세요.
		 * 반복횟수 : i는 num1부터 1까지 1씩 감소
		 * 규칙성 : i가 num1과 num2의 약수이면 i를 출력한 후 반복문 종료
		 * 반복문 종료 후 : 없음
		 * */
		int num1 = 8, num2 = 12;
		int i = num1; 
		while(i >= 1) {
			if(num1 % i == 0 && num2 % i ==0) {
				System.out.println(num1 +"과 " + num2 +"의 최대 공약수 : " + i);
				break;
			}
			i--;
		}
		

	}

}
