package day17;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamEx02 {

	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("src/day17/byteStream3.txt")) {
			for(char ch ='A'; ch <= 'Z'; ch++) {
				fos.write(ch);
			}
			System.out.println("완료되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없거나 파일을 생성할 수 없습니다.");
		} catch (IOException e) {
			System.out.println("예외가 발생했습니다.");
		}

	}

}
