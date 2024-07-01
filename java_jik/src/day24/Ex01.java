package day24;

public class Ex01 {

	public static void main(String[] args) {
		int num1 = 4;
		double num2 = num1;
		
		/* 에러 발생
		 * 원인 : 실수를 정수로 자동 자료형변환 하려 했기 때문에
		 * 해결 방법 : 명시적 형변환을 하던지 실수형 변수에 저장
		 * */
		int num3 = (int)num2;

	}

}
