package db.student.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentVO{
	private int st_key;
	private int st_grade, st_class, st_num;
	private String st_name;
	
	public StudentVO(int grade, int classNum, int num, String name) {
		this.st_grade = grade;
		this.st_class = classNum;
		this.st_num = num;
		this.st_name = name;
	}
}
