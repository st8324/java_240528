package db.student.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectVO {

	private int su_key;//과목 기본키
	private String su_name;
	private int su_grade;
	private int su_semester;

	public SubjectVO(String name, int grade, int semester) {
		this.su_name = name;
		this.su_grade = grade;
		this.su_semester = semester;
	}
	
}
