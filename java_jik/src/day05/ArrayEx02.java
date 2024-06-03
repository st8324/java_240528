package day05;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* 학생 3명의 성적을 저장하는 배열을 생성하고, 
		 * 학생 3명의 성적을 콘솔을 통해 입력받고
		 * 입력받은 성적의 평균을 구하는 코드를 작성하세요. */
		
		int [] score = new int[3];
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		/*
		 * sum = sum + score[0];
		 * sum = sum + score[1];
		 * sum = sum + score[2];
		 * sum : 총점
		 */
		for(int i = 0; i < score.length; i++) {
			System.out.print("학생"+(i+1) +"의 성적 : ");
			score[i] = scan.nextInt();
			//총점을 구하기 위해 학생 성적을 입력할 때마다 누적을 시킴
			sum += score[i];//sum = sum + score[i];
		}
		
		for(int i = 0; i < score.length; i++) {
			System.out.println("학생"+(i+1) +"의 성적 : " + score[i]);
		}
		
		double avg = sum / (double)score.length;
		System.out.println("학생 "+score.length+"명의 평균 : " + avg);
		
		
	}

}
