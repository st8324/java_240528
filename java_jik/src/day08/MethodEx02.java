package day08;

public class MethodEx02 {

	public static void main(String[] args) {
		/* 두 수의 최대 공약수와 최소 공배수를 구하는 코드를 작성하세요. 단, 메서드 이용.*/
		int num1 = 8, num2 = 12;
		System.out.println(num1 + "과 " + num2 +"의 최대 공약수 : " + gcd(num1, num2));
		System.out.println(num1 + "과 " + num2 +"의 최소 공배수 : " + lcm(num1, num2));
		System.out.println(num1 + "과 " + num2 +"의 최소 공배수 : " + lcm2(num1, num2));
	}
	/**정수 num2가 정수 num1의 약수인지 아닌지를 알려주는 메서드
	 * 매개변수 : 정수 num1와 정수 num2 => long num1, long num2
	 * 리턴타입 : 약수인지 아닌지 => boolean
	 * 메서드명 : isDivisor
	 * */
	public static boolean isDivisor(long num1, long num2) {
		return num1 % num2 == 0;
	}
	/**정수 num1과 정수 num2의 최대 공약수를 알려주는 메서드
	 * 매개변수 : 정수 num1, 정수 num2 => int num1, int num2
	 * 리턴타입 : 두 정수의 최대 공약수 => 정수 => int
	 * 메서드명 : gcd
	 * */
	public static int gcd(int num1, int num2) {
		if(num1 > num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		for(int i = num1; i>=1; i--) {
			//i가 공약수이면
			if(isDivisor(num1, i) && isDivisor(num2, i)) {
				return i;
			}
		}
		return 1;
	}
	
	/**정수 num1과 정수 num2의 최소 공배수를 알려주는 메서드
	 * 매개변수 : 정수 num1과 정수 num2 => int num1, int num2
	 * 리턴타입 : 두 정수의 최소 공배수 => 정수 => long
	 * 메서드명 : lcm
	 * */
	public static long lcm(int num1, int num2) {
		for(long i = num1; i<=num1*(long)num2; i+=num1) {
			if(isDivisor(i, num2)) {
				return i;
			}
		}
		return num1 * num2;
	}
	/* g : 최대공약수
	 * A : ga, B : gb
	 * l : 최소공배수 
	 * l = gab = A * B / g
	 * */
	public static long lcm2(int num1, int num2) {
		return num1 * (long)num2 / gcd(num1, num2);
	}
	
}
