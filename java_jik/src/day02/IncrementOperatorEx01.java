package day02;

public class IncrementOperatorEx01 {
	//증감 연산자 예제
	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		
		++num1;
		num2++;
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		System.out.println("증가 전 num1 : " + num1  );
		System.out.println("증가 전 num2 : " + num2  );
		
		//System.out.println("증가 중 num1 : " + ++num1  );//전위형
		//System.out.println("증가 중 num2 : " + num2++  );//후위형
		num1++;
		System.out.println("증가 중 num1 : " + num1  );//전위형
		System.out.println("증가 중 num2 : " + num2  );//후위형
		num2++;
		
		System.out.println("증가 후 num1 : " + num1  );
		System.out.println("증가 후 num2 : " + num2  );

	}

}
