package day17;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamEx02 {

	public static void main(String[] args) {
		String fileName = "src/day17/charStream.txt";
		
		try(FileWriter fw = new FileWriter(fileName)){
			String str = "안녕하세요. 제 이름은 홍길동입니다.\n만나서 반갑습니다.";
			/*for(int i = 0; i<str.length(); i++) {
				fw.write(str.charAt(i));
			}*/
			fw.write(str);
		} catch (IOException e) {
			System.out.println("파일 입출력 예외가 발생했습니다.");
		}

	}

}
