package day15;

import java.util.ArrayList;
import java.util.Objects;

public class ListEx03 {

	public static void main(String[] args) {
		/* 연락처 클래스를 이용한 List 예제 
		 * indexOf, remove, contains를 확인 하는 예제*/
		ArrayList<Contact> list = new ArrayList<Contact>();
		
		Contact c1 = new Contact("홍길동", "010-1234-5678");
		Contact c2 = new Contact("홍길동", "010-1234-5678");
		
		list.add(c1);
		
		System.out.println(list);
		/* Objects.equals(객체1, 객체2)를 호출
		 * 1. 객체1과 객체2가 같은 클래스인지 확인
		 * 2. 객체1.equals(객체2)
		 * */
		list.remove(c2);
		
		System.out.println(list);
		
		list.add(c1);
		
		System.out.println(list);
		
		c1.name = "고길동";
		
		System.out.println(list);
		
		/* 복사 생성자를 이용하여 객체를 리스트에 저장하고 객체를 밖에서 수정해도 리스트는 영향이 없게 
		 * 하는 것이 좋다 */
		list.add(new Contact(c2));
		
		System.out.println(list);
		
		c2.name = "나길동";
		
		System.out.println(list);
	}

}

class Contact{
	
	public String name;
	public String number;
	
	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public Contact(Contact c) {
		this.name = c.name;
		this.number = c.number;
	}
	
	@Override
	public String toString() {
		return name + " : " + number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(number, other.number);
	}

}

