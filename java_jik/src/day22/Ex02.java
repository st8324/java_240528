package day22;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* 콘솔에서 정수로 이루어진 문자열을 입력받아 각 정수들의 합을 구하는 코드를 작성하세요.
		 * 예
		 * 1 23 45 3 9 7 5
		 * 103
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		String str = scan.nextLine();
		int sum = convertAndSum(str);
		System.out.println("합 : " + sum);
	}
	/* 위에서 작성한 코드 중 일부를 메소드로 만든다고 했을 때 필요하다고 생각하는 코드를 
	 * 메소드로 만들어 보세요.*/
	/**주어진 문자열에 있는 정수들을 더해서 더한 결과를 반환하는 메소드
	 * @param str 정수들이 있는 문자열
	 * @return 문자열에 있는 정수들의 합
	 * */
	public static int convertAndSum(String str) {
		//split을 이용해서 문자열을 배열로 추출
		String [] nums = str.split(" ");
		int sum = 0;
		//반복문
		for(String num : nums) {
			//문자열을 정수로 변환
			int number = Integer.parseInt(num);
			//누적
			sum += number;
		}
		return sum;
	}
}


