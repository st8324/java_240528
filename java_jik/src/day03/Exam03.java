package day03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/* day03 패키지에 Exam03 클래스를 생성하세요.
		 * 2개의 과목 성적을 입력받아 평균 60점이 넘고 모든 과목이 과락(40점미만)이 없으면 합격, 아니면 불합격을 출력하는 코드를 작성하세요.
		 * (산술연산자(+), 비교연산자, 논리연산자, 조건연산자)
		 * 예시1
		 * 과목1 성적 입력 : 100
		 * 과목2 성적 입력 : 35
		 * 결과 : 불합격
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("과목1 성적 입력 : ");
		int score1 = scan.nextInt();
		
		System.out.print("과목2 성적 입력 : ");
		int score2 = scan.nextInt();
		
		//총점은 계산해서 sum에 저장
		int sum = score1 + score2;
		//총점을 이용하여 평균을 계산하여 avg에 저장
		double avg = (double)sum / 2;
		//과락이 있는지 확인하여 결과를 isFail에 저장
		boolean isFail = score1 < 40 || score2 < 40;
		//평균이 60점이상이고 과락이 아니면 합격, 아니면 불합격을 문자열 result에 저장
		//조건식 : 평균이 60점 이상이고 과락이 아니다
		//avg이 60보다 크거나 같다 && isFail이 아니다
		String result = (avg >= 60 && !isFail) ? "합격" : "불합격";
		//result를 이용하여 결과를 출력
		System.out.println(result);
	}

}
