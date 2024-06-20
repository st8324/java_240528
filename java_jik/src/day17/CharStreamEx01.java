package day17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamEx01 {

	public static void main(String[] args) {
		
		String fileName = "src/day17/byteStream2.txt";
		
		try(FileReader fr = new FileReader(fileName)){
			while (fr.ready()) {
				char ch = (char)fr.read();
				System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일 입출력에서 예외가 발생했습니다.");
		}

	}

}
