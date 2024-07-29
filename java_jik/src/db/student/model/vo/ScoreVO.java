package db.student.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScoreVO {
	private int sc_key; 
	private int sc_midTerm; 
	private int sc_finalTerm; 
	private int sc_performance; 
	private int sc_st_key; 
	private int sc_su_key;

	public ScoreVO(int midterm, int finals, int performace) {
		this.sc_midTerm = midterm;
		this.sc_finalTerm = finals;
		this.sc_performance = performace;
	}
}
