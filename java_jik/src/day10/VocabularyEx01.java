package day10;

import java.util.Arrays;
import java.util.Scanner;

public class VocabularyEx01 {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 메뉴
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 검색
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 : 
		 * */


		int menu = 0;
		final int WORD_MAX = 2; 
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
				wordCount = insertWord(list, wordCount);
				//단어 리스트가 다 찼으면 단어 리스트를 늘려줌
				if(wordCount == list.length) {
					list = expandWordList(list, list.length + 10);
				}
				for(int i = 0; i<wordCount; i++) {
					list[i].print();
				}
				
				break;
			case 2:	
				//단어 수정을 구현하기 위한 과정을 주석으로 작성. 같은 단어가 있는 경우
				//누구를 수정할지를 선택하는 부분을 고민해야 함.
				updateWord(list, wordCount);
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
	
	/**기능 : list에 index 번지에 있는 단어가 word인지 아닌지 알려주는 메소드
	 * @param list 단어 리스트
	 * @param word 검색할 단어
	 * @param index 해당 단어의 번지
	 * @return index 번지에 word가 있으면 true, 없으면 false
	 */
	public static boolean checkWord(Word[] list, String word, int index) {
		if(list.length <= index || index < 0 ) {
			return false;
		}
		if(list[index] == null) {
			return false;
		}
		return list[index].getWord().equals(word);
	}

	/**기능 : 저장된 단어 리스트를 정렬하는 메소드
	 * @param list 단어 리스트
	 * @param wordCount 저장된 단어 개수
	 * */
	public static void wordSort(Word [] list, int wordCount){
		for(int i = 0; i < wordCount - 1; i++) {
			for(int j = 0; j < wordCount - 1; j++) {
				//j번지에 있는 단어가 사전순으로 j+1번지에 있는 단어보다 뒤이면 두 단어 객체를 교환
				//j번지에 있는 단어 : list[j].getWord() ,j+1번지에 있는 단어 : list[j+1].getWord()
				if(list[j].getWord().compareTo(list[j+1].getWord()) > 0) {
					Word tmpWord = list[j];
					list[j] = list[j+1];
					list[j+1] = tmpWord;
				}
			}
		}
	}
	
	/**기능 : 단어 정보를 입력받아 단어 객체를 돌려주는 메소드
	 * @return 단어 객체
	 * */
	public static Word inputWord() {
		//단어 정보(단어, 품사, 의미)를 입력
		System.out.print("단어 : ");
		String word = scan.next();
		System.out.print("품사 : ");
		String wordClass = scan.next();
		System.out.print("의미 : ");
		scan.nextLine();//공백 처리
		String meaning = scan.nextLine();
		//입력한 단어 정보를 이용하여 단어 객체를 생성
		Word tmp = new Word(word, wordClass, meaning);
		return tmp;
	}
	
	/**기능 : 단어 리스트에 단어를 입력받아 단어를 추가하고 등록된 단어 숫자를 알려주는 메소드
	 * @param list 단어 리스트
	 * @param wordCount 저장된 단어 개수
	 * @return 저장된 단어 개수
	 */
	public static int insertWord(Word[] list, int wordCount) {
		Word tmp = inputWord();
		//단어 리스트에 단어 객체를 저장 => 마지막으로 저장된 위치 다음에 단어 객체를 저장
		list[wordCount] = tmp;
		//저장된 단어 개수를 1 증가
		wordCount++;
		//단어 리스트를 정렬(알파벳순으로)
		wordSort(list, wordCount);
		System.out.println("------------------");
		System.out.println("단어 등록을 완료했습니다.");
		System.out.println("------------------");
		return wordCount;
	}
	/**기능 : 단어 리스트를 늘려서 돌려주는 메소드
	 * @param list 단어 리스트
	 * @param size 늘려줄 크기
	 * @return 늘어난 단어 리스트
	 */
	public static Word[] expandWordList(Word[] list, int size) {
		if(list.length >= size) {
			return list;
		}
		Word [] tmp = new Word[size];
		//list 0번지부터 list.length를 tmp의 0번지부터 복붙
		System.arraycopy(list, 0, tmp, 0, list.length);
		return tmp;
	}
	
	public static void updateWord(Word[] list, int wordCount) {
		//수정할 단어를 입력
		System.out.print("단어 : ");
		String word = scan.next();
		int count = 0;//일치하는 단어가 몇개 있는지 확인하는 변수
		//단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
		for(int i = 0; i < wordCount; i++) {
			if(list[i].getWord().equals(word)) {
				System.out.print(i+1+".");
				list[i].print();
				count++;
			}
		}
		//수정할 단어가 없으면 안내문구 출력 후 종료
		if(count == 0) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
		//수정할 단어를 선택
		System.out.print("수정할 단어 번호 선택 : ");
		int num = scan.nextInt();
		boolean res = checkWord(list, word, num-1);
		if(!res) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		//수정할 단어, 품사, 의미를 입력
		Word tmp = inputWord();
		//입력한 정보로 선택한 단어를 수정
		list[num-1].updateWord(tmp);
		list[num-1].print();
		//단어리스트 정렬
		wordSort(list, wordCount);
		System.out.println("------------------");
		System.out.println("단어 수정을 완료했습니다.");
		System.out.println("------------------");
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
	/**기능 : 새 단어정보가 주어지면 수정하는 메소드
	 * @param word 새 단어 정보 
	 * */
	public void updateWord(Word word) {
		this.word = word.word;
		this.wordClass = word.wordClass;
		this.meaning = word.meaning;
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
