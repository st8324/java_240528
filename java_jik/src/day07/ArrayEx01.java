package day07;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* 3명의 학생의 국어, 영어, 수학 성적을 입력받고
		 * 각 학생의 평균을 구하는 코드를 작성하세요.
		 * 학생1의 성적을 입력하세요(국어, 영어, 수학 순) : 100 90 80
		 * 학생2의 성적을 입력하세요(국어, 영어, 수학 순) : 100 100 100
		 * 학생3의 성적을 입력하세요(국어, 영어, 수학 순) : 81 80 80
		 * 학생1의 평균 : 90
		 * 학생2의 평균 : 100
		 * 학생3의 평균 : 80.333333
		 * */
		int [] kor, eng, math;
		int studnetCount = 3;
		kor = new int[studnetCount];
		eng = new int[studnetCount];
		math = new int[studnetCount];

		Scanner scan = new Scanner(System.in);

		//반복문을 이용하여 학생 성적을 입력
		//i는 0부터 3보다 작을때까지 1씩 증가
		for(int i = 0; i < studnetCount ; i++ ) {
			//학생(i+1)의 성적 입력 문구를 출력
			System.out.print("학생" + (i+1) + "의 성적을 입력하세요(국어, 영어, 수학 순) : ");
			//국어, 영어, 수학 점수를 입력 => 배열에 저장
			kor[i] = scan.nextInt();
			eng[i] = scan.nextInt();
			math[i] = scan.nextInt();
		}
		int sum;
		double avg;
		//각 학생의 평균을 구함
		sum = kor[0] + eng[0] + math[0];
		avg = sum/3.0;
		System.out.println("학생"+(0+1)+"의 평균 : " + avg);

		sum = kor[1] + eng[1] + math[1];
		avg = sum/3.0;
		System.out.println("학생"+(1+1)+"의 평균 : " + avg);

		sum = kor[2] + eng[2] + math[2];
		avg = sum/3.0;
		System.out.println("학생"+(2+1)+"의 평균 : " + avg);

		for(int i = 0; i<studnetCount; i++) {
			sum = kor[i] + eng[i] + math[i];
			avg = sum/3.0;
			System.out.println("학생"+(i+1)+"의 평균 : " + avg);
		}
		/* 각 과목의 평균을 구하는 코드를 작성하세요.
		 * 국어 평균 : 93.666666
		 * 영어 평균 : 90
		 * 수학 평균 : 86.666666
		 * */
		//국어 평균
		/*
		sum = kor[0] + kor[1] + kor[2];
		sum = 0;
		sum = sum + kor[0];
		sum = sum + kor[1];
		sum = sum + kor[2];
		 */
		sum = 0;
		for(int i = 0; i<kor.length; i++) {
			sum = sum + kor[i]; // sum += kor[i];
		}
		avg = sum / (double) kor.length;
		System.out.println("국어 평균 : " + avg);

		//영어 평균
		sum = 0;
		for(int i = 0; i<eng.length; i++) {
			sum = sum + eng[i]; 
		}
		avg = sum / (double) eng.length;
		System.out.println("영어 평균 : " + avg);

		//수학 평균
		sum = 0;
		for(int i = 0; i<math.length; i++) {
			sum = sum + math[i]; 
		}
		avg = sum / (double) math.length;
		System.out.println("영어 평균 : " + avg);
	}

}
