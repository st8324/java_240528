package day17;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point implements Serializable{
	
	/**이름이 같은 클래스이어도 serialVersionUID가 다릉면 읽어오지 못함
	 */
	private static final long serialVersionUID = -7368159607806505364L;
	
	private int x, y;
	
	transient int i;
	
}
