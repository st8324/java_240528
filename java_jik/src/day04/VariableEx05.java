package day04;

public class VariableEx05 {

	public static void main(String[] args) {
		// 실수 소수점 유효범위 확인하는 예제
		float num1 = 0.12345678f;
		double num2 = 0.123456789012345678;
		
		System.out.printf("%.20f\n", num1);
		System.out.printf("%.20f\n", num2);

	}

}
