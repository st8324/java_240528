package day02;

public class CastingEx01 {

	public static void main(String[] args) {
		/* 자료형변환 
		 * - 상수, 변수, 리터럴의 자료형을 일시적으로 변환시키는 것
		 * */
		double num1 = 3;//자동 자료형변환이 동작. 정수를 실수로 변환하여 저장
		long num2 = 3; //자동 자료형변환이 동작. 정수 리터럴은 int
		int num3 = 3; //
		long num4 = num3; //자동 자료형변환이 동작.

		int num5 = (int)3.14;//명시적 자료형변환을 통해 실수를 정수로 변환
		System.out.println(num5);
		byte num6 = (byte)num5;//명시적 자료형변환을 했지만 다행히도 짤리는 값이 없는 경우. 원래 값과 결과가 같음
		System.out.println(num6);
		byte num7 = (byte)123123;//명시적 자료형변환을 해서 짤리는 값이 있는 경우. 원래 값과 결과가 다름
		System.out.println(num7);
		
		//자동 자료형변환이 일어나지만 명시적 자료형변환이 필요한 경우
		double res = 1/2;//1/2의 결과인 0이 자동자료형변환을 통해 0.0으로 변환
		System.out.println(res);
		
		res = 1 / (double)2;//2를 명시적 자료형변환으로 변환하여 1/2.0을 계산해서 0.5를 저장
		System.out.println(res);
		
	}

}
