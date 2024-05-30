package day03;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		/* IfExam06 클래스를 생성하세요.
		 * 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * 90이상 ~ 100이하 : A
		 * 80이상 ~ 90미만 : B
		 * 70이상 ~ 80미만 : C
		 * 60이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 성적입니다
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = scan.nextInt();
		
		/* 성적이 0보다 작거나 100보다 크면 잘못된 성적입니다라고 출력하고
		 * 아니면 성적이 90점 이상이면 A라고 출력하고
		 * 아니면 성적이 80점 이상이면 B라고 출력하고
		 * 아니면 성적이 70점 이상이면 C라고 출력하고
		 * 아니면 성적이 60점 이상이면 D라고 출력하고
		 * 아니면 F라고 출력
		 * */
		if(score < 0 || score > 100) {
			System.out.println("잘못된 성적입니다.");
		}
		//여기까지 왔다면 score는 0이상 100이하
		else if(score >= 90) {
			System.out.println("A");
		}
		//여기까지 왔다면 score는 0이상 90미만
		else if(score >= 80) {
			System.out.println("B");
		}
		//여기까지 왔다면 score는 0이상 80미만
		else if(score >= 70) {
			System.out.println("C");
		}
		//여기까지 왔다면 score는 0이상 70미만
		else if(score >= 60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
	}

}
