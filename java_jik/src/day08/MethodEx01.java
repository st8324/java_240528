package day08;

public class MethodEx01 {

	/* 주어진 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
	 * 단, 메서드를 이용해서
	 * */
	public static void main(String[] args) {
		//num가 소수인지 판별하는 코드
		int num = 8;
		
		boolean result = isPrime(num);
		
		if(result) {
			System.out.println(num +"는 소수");
		}
		else {
			System.out.println(num+"는 소수 아님");
		}
		//100이하의 소수를 출력하는 코드를 작성하세요. isPrime을 이용하여
		for(num = 2; num <= 100; num++) {
			if(isPrime(num)) {
				System.out.print(num + " ");
			}
		}
		
	}
	/**주어진 정수가 소수인지 아닌지 알려주는 메서드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => 맞다 틀리다 => boolean
	 * 메서드명 : isPrime
	 * */
	public static boolean isPrime(int num) {
		int count = 0;
		for(int i = 1; i<= num; i++) {
			if(num % i == 0) {
				count++;
			}
		}
		
		return count == 2 ? true : false;
		
		/*
		if(count == 2) {
			return true;
		}
		return false;
		*/
		/*
		if(count == 2) {
			return true;
		}
		else {
			return false;
		}
		*/
		/*
		boolean result;
		if(count == 2) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
		*/
	}
	public static boolean isPrime2(int num) {
		if(num == 1) {
			return false;
		}
		//1과 자기자신을 제외한 수 중에서 약수를 반복문을 이용하여 찾음
		for(int i = 2; i<num; i++) {
			//1과 자기자신을 제외한 수 중에서 약수가 있으면
			if(num % i == 0) {
				//소수가 아님
				return false;
			}
		}
		//반복문이 끝날때까지 약수를 못찾았다 => 약수가 1과 자기자신뿐이다 => 소수이다
		return true;
	}
}


