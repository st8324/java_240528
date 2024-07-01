package day24;

public class Ex11 {

	public static void main(String[] args) {
		/* 1 + 2를 계산하기 위해 sum을 호출했다.
		 * 원인 : 클래스 메소드에서 객체 메소드를 호출할 수 없다
		 * 해결방법 : 객체 메소드를 클래스 메소드로 수정하거나 객체를 생성한 후 호출
		 * */
		//int res = sum(1,2);
		Ex11 ex = new Ex11();
		int res = ex.sum(1, 2);
		System.out.println(1 + " + " + 2 + " = " + res);
	}

	public int sum(int num1, int num2) {
		return num1 + num2;
	}
}
