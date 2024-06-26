package day21.socket2;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String num;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(num, other.num);
	}
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	@Override
	public String toString() {
		return "[" + name + " : " + num + "]";
	}
	public void update(Contact newContact) {
		this.name = newContact.name;
		this.num = newContact.num;
		
	}
	
}
