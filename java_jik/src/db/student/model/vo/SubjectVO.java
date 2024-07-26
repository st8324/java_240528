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
	
}
