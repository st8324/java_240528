package day15;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx02 {

	public static void main(String[] args) {
		//List 반복문 예제
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("hi");
		list.add("apple");
		list.add("banana");
		
		for(String tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();

		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		for(int i = 0; i<list.size(); i++) {
			String tmp = list.get(i);
			System.out.print(tmp + " ");
		}
	}

}
