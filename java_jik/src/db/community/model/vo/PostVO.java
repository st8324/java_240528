package db.community.model.vo;

import java.text.SimpleDateFormat;
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

	public PostVO(int coNum, String title, String content, String id) {
		this.po_co_num = coNum;
		this.po_title = title;
		this.po_content = content;
		this.po_me_id = id;
	}

	@Override
	public String toString() {
		return po_num + " | " + po_title + " | " + po_me_id + " | " + getPo_date()
				+ " | " + po_view;
	}
	
	public void print() {
		System.out.println("---------------------");
		System.out.println("번호 : " + po_num);
		System.out.println("제목 : " + po_title);
		System.out.println("작성자 : " + po_me_id);
		System.out.println("작성일 : " + getPo_date());
		System.out.println("조회수 : " + po_view);
		System.out.println("내용 : " + po_content);
		System.out.println("---------------------");
	}
	public String getPo_date() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(po_date);
	}

	public PostVO(int po_num, String title, String content) {
		this.po_num = po_num;
		this.po_title = title;
		this.po_content = content;
	}
}
