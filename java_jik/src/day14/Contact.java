package day14;

import java.util.Objects;
import java.util.regex.Pattern;

public class Contact {
	private String name;
	private String number;

	public Contact(String name, String number) throws Exception {
		this.name = name;
		setNumber(number);
	}
	
	//hashCode equals는 전화번호가 같으면 등록이 되면 안되고, 수정할 때도 있는 번호는 등록되면 안되기 때문에
	//equals를 오버라이딩 하면 같은 번호인지 아닌지 비교하기가 쉽다
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
	//toString을 오버라이딩하면 이름 : 번호 형태의 문자열이 필요할 때 사용하기가 좋다(여러번 필요하기 때문에)
	@Override
	public String toString() {
		//홍길동 : 010-1234-2333
		return name + " : " + number;
	}
	//getter & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) throws Exception {
		//주어진 번호가 전화 번호 형태가 아니면 예외를 발생 시키고 맞으면 번호에 저장
		//010-1234-5677 또는 02-123-4568 또는 041-234-5678 형태의 문자열을 처리하기 위한 정규표현식
		String regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		if(!Pattern.matches(regex, number)) {
			throw new Exception("주어진 번호는 번호 형태가 아닙니다.");
		}
		this.number = number;
	}
}
