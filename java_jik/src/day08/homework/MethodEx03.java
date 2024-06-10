package day08.homework;

import java.util.Arrays;

public class MethodEx03 {

	/* 배열에 랜덤으로 1~9사이의 중복되지 않은 배열을 생성하고 콘솔에 출력하는 코드를 작성하세요.
	 * 단 메서드 이용
	 * day08.homework.MethodEx01, day08.homework.MethodEx02, day08.MethodEx05를 합친 예제
	 * */
	public static void main(String[] args) {
		int size = 6, min = 1, max = 45;
		int [] arr = createRandomArray(size, min, max);
		System.out.println(Arrays.toString(arr));
	}
	/**기능 : 최소값과 최대값 사이의 랜덤한 정수를 생성해서 알려주는 메서드
	 * 매개변수 : 최소값과 최대값 => int min, int max
	 * 리턴타입 : 랜덤한 정수 => int 
	 * 메서드명 : random
	 * */
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	/**기능 : 배열에 0번지부터 count-1번지까지 확인하려는 정수가 있는지 확인해서 있는지 없는지를 알려주는 메서드 
	 * 매개변수 : 배열, 확인할 갯수 count,확인하려는 정수 => int []arr, int count, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메서드명 : contains
	 * */
	public static boolean contains(int []arr, int count, int num) {
		//배열이 null인 경우
		if(arr == null) {
			return false;
		}
		//count가 배열의 크기보다 큰 경우
		if(count > arr.length) {
			count = arr.length;
		}
		for(int i = 0; i < count; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		
		return false;
	}

	/**기능 : 배열의 크기와 최소값과 최대값이 주어졌을 때, 중복되지 않은 랜덤한 배열을 만들어서 알려주는 메서드 
	 * 매개변수 : 배열의 크기, 최소값과 최대값 => int size, int min, int max
	 * 리턴타입 : 중복되지 않은 랜덤한 정수가 들어있는 배열 => int []
	 * 메서드명 : createRandomArray
	 */
	public static int [] createRandomArray(int size, int min, int max) {
		if(size < 0) {
			return null;
		}
		
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		
		//랜덤 숫자의 범위가 배열의 크기보다 작은 경우. 
		//랜덤 범위가 1~9, 크기가 20
		if(size > max - min + 1) {
			return null;
		}
		
		int count = 0;//저장된 숫자의 개수 
		int [] arr = new int[size];
		while(count < size) {
			int random = random(min, max);
			if(!contains(arr, count, random)) {
				arr[count] = random;
				count++;
			}
		}
		return arr;
	}
}
