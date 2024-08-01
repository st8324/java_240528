package db.community.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {


	private int coNum;
	
	public PostCriteria(int page, String search, int coNum) {
		super(page, search);
		this.coNum = coNum;
	}
	
}
