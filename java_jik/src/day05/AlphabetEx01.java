package day05;

public class AlphabetEx01 {

	public static void main(String[] args) {
		
		/* a				i=0		a부터 a까지=>	'a'+0까지
		 * ab				i=1		a부터 b까지=>	'a'+1까지
		 * abc				i=2		a부터 c까지=>	'a'+2까지
		 * abcd				i=3		a부터 d까지=>	'a'+3까지
		 * ...
		 * abcdefg...xyz	i=25	a부터 z까지=>	'a'+25까지
		 * 							a부터 'a'+i까지
		 * 반복횟수 : i는 0부터 26보다 작을 때까지 1씩 증가
		 * 규칙성 : a부터 'a'+i까지 알파뱃을 출력
		 * 		=>	반복횟수 : j는 0부터 i까지 1씩 증가
		 * 			규칙성 : 'a'+j를 출력
		 * 			반복문 종료 후 : 엔터 출력
		 * 반복문 종료 후 : 없음
		 * */
		int i, j;
		for( i = 0 ; i < 26 ; i++ ) {
			for( j = 0 ; j <= i ; j++ ) {
				System.out.print((char)('a' + j));
			}
			System.out.println();
		}
		
		/* 반복횟수 : ch1은 'a'부터 'z'까지 1씩 증가
		 * 규칙성 : ch2는 'a'부터 ch1까지 출력
		 * 		=> 	반복횟수 : ch2는 'a'부터 ch1까지 1씩 증가
		 * 			규칙성 : ch2를 출력
		 * 			반복문 종료 후 : 엔터를 출력
		 * 반복문 종료 후 : 없음
		 * */
		char ch1, ch2;
		for(ch1 = 'a'; ch1 <= 'z'; ch1++) {
			for(ch2 = 'a'; ch2 <= ch1; ch2++) {
				System.out.print(ch2);
			}
			System.out.println();
		}
	}

}
