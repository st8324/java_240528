package db.student.model.vo;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		return st_class == other.st_class && st_grade == other.st_grade && st_num == other.st_num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(st_class, st_grade, st_num);
	}

	@Override
	public String toString() {
		return st_grade + "학년 " + st_class + "반 " + st_num + "번 "	+ st_name;
	}
	
	
}
