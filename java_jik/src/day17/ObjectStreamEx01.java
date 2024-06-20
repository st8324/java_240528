package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamEx01 {

	public static void main(String[] args) {
		
		String fileName = "src/day17/objectStream.txt";
		List<Point> points = Arrays.asList(
				new Point(1,10, 1),
				new Point(3,3, 2),
				new Point(5,5, 3),
				new Point(10,5, 4));
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			for(Point tmp : points) {
				oos.writeObject(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 예외가 발생했습니다.");
		}
		
		List<Point> points2 = new ArrayList<Point>();
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			Point tmp;
			do {
				tmp = (Point)ois.readObject();
				if(tmp != null) {
					points2.add(tmp);
				}
			}while(tmp!=null);
		} catch (IOException e) {
			System.out.println("입출력 예외가 발생했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
		System.out.println(points2);
		

	}

}
