package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamEx01 {

	public static void main(String[] args) {
		//바이트 기반 입출력 스트림 예제
		
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream("src/day17/byteStream.txt");
			/* 파일에 "1"(문자열)이 저장되어 있으면 처음 read로 읽어올 때 문자1을 읽어오고
			 * 두번째 read로 읽어올 때 더 읽어올 내용이 없어서 -1을 반환
			 * */
			int data = fis.read();
			System.out.println(data);
			data = fis.read();
			System.out.println(data);
			
			fis2 = new FileInputStream("src/day17/byteStream2.txt");
			do {
				data = fis2.read();
				System.out.print((char)data);
			}while(data != -1);
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일 읽기에 실패했습니다.");
		} finally {
			
			try {
				if(fis != null) {
					fis.close();
				}
				if(fis2 != null) {
					fis2.close();
				}
			} catch (IOException e) {
				System.out.println("파일을 닫을 수 없습니다.");
			}
		}

	}

}
