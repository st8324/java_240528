package day06;

public class ArrayEx02 {

	public static void main(String[] args) {
		// 배열은 생성 시 초기화가 되는지 보여주는 예제
		int num1;
		
		//System.out.println(num1); //에러 발생 : 지역변수는 자동으로 초기화가 안 된다.
		num1 = 10;//초기화를 하고
		System.out.println(num1); //에러 발생하지 않음

		int [] arr = new int[3];
		for(int tmp : arr) {
			System.out.println(tmp);//배열은 배열 생성 시 각 자료형에 맞는 초기값으로 초기화가 됨
		}
		//arr[3] = 20;//잘못된 번지를 접근해서 예외가 발생
	}

}
