package day06;

public class ArraySortEx01 {

	public static void main(String[] args) {
		int [] arr = new int[] { 1,3,5,7,9,2,4,6,8,10};

		//버블 정렬 : 옆에 있는 값들을 비교해서 정렬하는 방식
		//한 번 실행되면 하나의 숫자가 정렬이 됨
		/* 1 3 5 7 9 2 4 6 8 10
		 * 1 3 5 7 2 4 6 8 9 10 10이 결정(가장 큰 값) => 9번
		 * 1 3 5 2 4 6 7 8 9 10 9가 결정(2번째 큰 값) => 8번 
		 * */
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				//앞의 숫자가 크면 순서를 바꿔야 함.
				if(arr[j] < arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
	}

}
