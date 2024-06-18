package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx03 {

	public static void main(String[] args) {
		//인터페이스 다형성과 Map의 활용
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(0, "123");
		map.put(1, 1);
		map.put(2, new Scanner(System.in));
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("title", "안녕하세요");
		map2.put("age", 21);

	}

}
