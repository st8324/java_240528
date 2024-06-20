package day17.contact;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	private String number;
	private String name;
	@Override
	public String toString() {
		return name + " : " + number;
	}
	
	
}
