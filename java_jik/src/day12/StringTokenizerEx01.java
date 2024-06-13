package day12;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		//StringTokenizer : 문자열이 한 종류의 구분자로 되어 있는 경우 토큰을 쉽게 분리할 수 있게 하는 클래스
		String fruit = "사과,포도,배";
		StringTokenizer st = new StringTokenizer(fruit, ",");
		//hasMoreTokens() : 토큰이 더 있는지를 알려주는 메소드
		while(st.hasMoreTokens()){
			String token = st.nextToken();//토큰을 가져옴
			System.out.println(token);
		}


	}

}
