package day12;

public class WrapperEx01 {

	public static void main(String[] args) {
		//문자열을 정수로
		String str1 = "123";
		int num = Integer.parseInt(str1);
		System.out.println(num);

		//문자열을 실수로
		String str2 = "3.14";
		double num2 = Double.parseDouble(str2);
		System.out.println(num2);

	}

}
