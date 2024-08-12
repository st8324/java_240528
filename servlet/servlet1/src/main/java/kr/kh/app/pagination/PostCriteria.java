package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {
	
	private int co_num;
	private String type;
	
	public PostCriteria(int page, int perPageNum, String search, int co_num, String type) {
		super(page, perPageNum, search);
		this.co_num = co_num;
		this.type = type;
	}

}