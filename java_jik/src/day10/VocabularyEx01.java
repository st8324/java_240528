package day10;

import java.util.Scanner;

public class VocabularyEx01 {

	public static void main(String[] args) {
		/* 메뉴
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 검색
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 : 
		 * */

		Scanner scan = new Scanner(System.in);
		int menu = 0;
		final int WORD_MAX = 10; 
		Word [] list = new Word[WORD_MAX];//단어 리스트
		int wordCount = 0;//저장된 단어 갯수
		//반복 : 종료를 선택하지 않을 때까지
		do {
			//메뉴 출력
			System.out.println("메뉴");
			System.out.println("1. 단어 등록");
			System.out.println("2. 단어 수정");
			System.out.println("3. 단어 검색");
			System.out.println("4. 단어 삭제");
			System.out.println("5. 종료");
			System.out.print("메뉴 선택 : ");
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:	
				//단어 정보(단어, 품사, 의미)를 입력
				
				//입력한 단어 정보를 이용하여 단어 객체를 생성
				
				//단어 리스트에 단어 객체를 저장 => 마지막으로 저장된 위치 다음에 단어 객체를 저장
				
				//저장된 단어 개수를 1 증가
				
				//단어 리스트를 정렬(알파벳순으로)
								
				break;
			case 2:	System.out.println("단어 수정 기능 구현 중입니다.");
				break;
			case 3:	System.out.println("단어 검색 기능 구현 중입니다.");
				break;
			case 4:	System.out.println("단어 삭제 기능 구현 중입니다.");
				break;
			case 5:	System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 5);
	}
}










/**영어 단어를 관리하기 위한 Word 클래스를 만들고, 
 * 필요한 멤버변수들을 선언해보세요. 
 * */
class Word{
	//단어, 뜻, 품사
	private String word, meaning, wordClass;
	
	//생성자
	public Word(String word, String wordClass, String meaning) {
		this.word = word;
		this.wordClass = wordClass;
		this.meaning = meaning;
	}

	//필요한 기능
	/**기능 : 단어를 출력하는 메소드
	 * */
	public void print() {
		System.out.println("------------------");
		System.out.println("단어 : " + word);
		System.out.println("품사 : " + wordClass);
		System.out.println("의미 : " + meaning);
		System.out.println("------------------");
	}
	
	//getter와 setter
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getWordClass() {
		return wordClass;
	}

	public void setWordClass(String wordClass) {
		this.wordClass = wordClass;
	}
	
	
}
