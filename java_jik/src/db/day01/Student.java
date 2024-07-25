package db.day01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student{
	private int studentNum;
	private int grade, classNum, num;
	private String name;
	@Override
	public String toString() {
		return "" + studentNum + " : [" + grade + "학년 " + classNum + "반" + num
				+ "번 " + name + "]";
	}
	
}