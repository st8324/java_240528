package day17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStreamEx01 {

	public static void main(String[] args) {
		
		String fileName = "src/day17/charStream.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String str;
			/*do {
				str = br.readLine();
				System.out.println(str);
			}while(str != null);
			*/
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 예외가 발생했습니다.");
		}

	}

}
