package day02;

public class StringEx01 {

	public static void main(String[] args) {
		String str1 = null;
		String str2 = "안녕하세요.";
		String str3 = "null";
		String str4 = "";//문자열은 0자이상
		
		System.out.println(str1);//이 때 출력되는 null은 null이라는 문자열이 저장된게 아니라 null값이 있다는 의미
		System.out.println(str2);
		System.out.println(str4);
		System.out.println(str3);//이 때 출력되는 null은 null이라는 문자열
	}

}
