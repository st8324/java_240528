package day02;

public class VariableInitEx01 {

	public static void main(String[] args) {
		int num;
		//The local variable num may not have been initialized 발생
		//System.out.println(num);//num를 초기화 하지 않아서 에러 발생 
		
		num = 0;
		
		System.out.println(num);//num를 초기화 해서 에러 발생하지 않음

	}

}
