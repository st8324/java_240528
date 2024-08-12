package kr.kh.app.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostVO {
	private int po_num; 
	private String po_title;
	private String po_content;
	private String po_me_id;
	private int po_co_num;
	private Date po_date; 
	private int po_view;
	private int po_report;

	public PostVO(int co_num, String title, String content, String id) {
		this.po_co_num = co_num;
		this.po_title = title;
		this.po_content = content;
		this.po_me_id = id;
	}
}
