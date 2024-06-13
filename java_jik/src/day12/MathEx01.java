package day12;

public class MathEx01 {

	public static void main(String[] args) {
		//abs() : 절대값
		System.out.println("-1의 절댓값 : " + Math.abs(-1));
		System.out.println("-1의 절댓값 : " + (-1<0?-(-1):-1));
		
		//ceil() : 소수점 첫번째 자리에서 올림
		System.out.println("1.23을 소수점 첫번째 자리에서 올림 : " + Math.ceil(1.23));
		
		//floor() : 소수점 첫번째 자리에서 버림
		System.out.println("1.23을 소수점 첫번째 자리에서 버림 : " + Math.floor(1.23));
		
		//round() : 소수점 첫번째 자리에서 반올림 후 정수를 리턴
		System.out.println("1.23을 소수점 첫번째 자리에서 올림 : " + Math.round(1.23));
		
		//sqrt() : 루트
		System.out.println("루트 16 : " + Math.sqrt(16));
		
		//pow() : n제곱
		System.out.println("2의 3제곱 : " + Math.pow(2, 3));
	}

}
