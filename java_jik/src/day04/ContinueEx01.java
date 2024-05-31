package day04;

public class ContinueEx01 {

	public static void main(String[] args) {
		// 1부터 10사이의 짝수 출력 예제(continue 사용)
		int i = 0;
		while(i < 10) {
			i++;
			//홀수이면 i를 출력하지 않고 건너뜀
			if(i % 2 != 0) {
				continue;//while문에서는 조건식으로 건너 뜀
			}
			System.out.println(i);
		}

	}

}
