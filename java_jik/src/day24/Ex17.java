package day24;

import java.io.FileWriter;
import java.io.IOException;

public class Ex17 {

	public static void main(String[] args) {
		/* 파일을 이어 쓰려면 뒤에 true를 추가 */
		try(FileWriter fw = new FileWriter("src/day24/ex17.txt", true);) {
			fw.write('a');
			fw.write('b');
			fw.write('c');
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
