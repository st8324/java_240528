package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/*day03 패키지에 Exam02 클래스를 생성하세요.
		 * 학생 3명의 성적을 입력받아 총점과 평균을 구하는 코드를 작성하세요.
		 * 예시1
		 * 학생1 성적 입력 : 65
		 * 학생2 성적 입력 : 100
		 * 학생3 성적 입력 : 76
		 * 총점 : 241점. 평균 : 80.3333333
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생1 성적 입력 : ");
		int score1 = scan.nextInt();
		
		System.out.print("학생2 성적 입력 : ");
		int score2 = scan.nextInt();
		
		System.out.print("학생3 성적 입력 : ");
		int score3 = scan.nextInt();

		//총점은 입력받은 세 학생의 성적을 다 더하면 됨
		int sum = score1 + score2 + score3;
		//총점을 이용하여 평균을 계산
		double avg = (double)sum / 3;
		System.out.println("총점 : "+ sum +"점. 평균 : " + avg);
	}

}
