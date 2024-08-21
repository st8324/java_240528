package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {
	

	protected int page = 1;
	protected int perPageNum = 5; //현재 페이지의 최대 컨텐츠 수
	
	protected String search = "";
	
	public Criteria(int page, int perPageNum, String search) {
		this.page = page;
		this.perPageNum = perPageNum;
		this.search = search;
	}
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}