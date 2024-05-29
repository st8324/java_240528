package day02;

public class VariableEx02 {
	
	public static void main(String[] args) {
		int num1 = 0x11; //16진수 11=> 16*1 + 1*1 = 17
		int num2 = 0b11; //2진수 11=> 3	
		int num3 = 011;  //8진수 11=> 9
		int num4 = 11;	 //10진수 11 => 10 * 1 + 1 * 1
		//123(16) => 16의 2제곱 * 1 + 16의 1제곱 * 2 + 16의 0제곱 * 3
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
				
	}
}
