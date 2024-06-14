package day13;

import java.util.Arrays;
import java.util.Comparator;

public class Ex01 {

	public static void main(String[] args) {
		/* 다음과 같은 책 제목들이 있을 때 원하는 단어를 검색해서 해당 단어가 있는 책을 출력하는 코드를 작성하세요.
		 * 일치하는 책이 없는 경우 일치하는 책이 없습니다라고 출력. */
		String [] books = {"자바의 정석", "혼자하는 자바", "혼자하는 C", "수학의 정석", "누구나 하는 C"};
		
		String search = "자바";
		int count = 0;
		for(String book : books) {
			//book에 search가 포함되어 있으면 book을 출력
			/*if(book.contains(search)) {
				System.out.println(book);
				count++;
			}*/
			if(book.indexOf(search) >= 0) {
				System.out.println(book);
				count++;
			}
		}
		//일치하는 책의 개수가 0이면 출력
		if(count == 0) {
			System.out.println("일치하는 책이 없습니다");
		}
	}
}