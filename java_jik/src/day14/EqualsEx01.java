package day14;

import java.util.Objects;

public class EqualsEx01 {

	//Object.equals 예제
	public static void main(String[] args) {
		PhoneNumber pn1 = new PhoneNumber("010-1234-5678");
		System.out.println(pn1.equals(1));
		System.out.println(pn1.equals("010-1234-5678"));

	}

}

class PhoneNumber{
	
	public String number;

	public PhoneNumber(String number) {
		super();
		this.number = number;
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
		if (getClass() != obj.getClass()) {
			if(obj instanceof String) {
				return number.equals(obj);
			}
			return false;
		}
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(number, other.number);
	}
	
	
}
