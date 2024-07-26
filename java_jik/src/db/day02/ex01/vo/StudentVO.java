package db.day02.ex01.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO{
	private int studentNum;
	private int grade, classNum, num;
	private String name;
	@Override
	public String toString() {
		return "" + studentNum + " : [" + grade + "학년 " + classNum + "반" + num
				+ "번 " + name + "]";
	}
	
}