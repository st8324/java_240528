package kr.kh.app.model.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	private int cm_num;
	private String cm_content;
	private int cm_po_num; 
	private int cm_ori_num; 
	private Date cm_date;
	private String cm_me_id;
	private int cm_report;
	private int cm_state;
	
	public String getCm_date() {
		if(isToday()) {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			return format.format(cm_date);
		}else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(cm_date);
		}
	}
	public boolean isToday() {
		Calendar today = Calendar.getInstance();
		Calendar date = Calendar.getInstance();
		date.setTime(cm_date);
		//년이 다르면
		if(today.get(Calendar.YEAR) != date.get(Calendar.YEAR)) {
			return false;
		}
		//월이 다르면
		if(today.get(Calendar.MONTH) != date.get(Calendar.MONTH)) {
			return false;
		}
		//일이 다르면
		if(today.get(Calendar.DAY_OF_MONTH) != date.get(Calendar.DAY_OF_MONTH)) {
			return false;
		}
		//년, 월, 일 모두 같으면
		return true;
	}
	public CommentVO(int cm_po_num, int cm_ori_num, String cm_content, String cm_me_id) {
		this.cm_po_num = cm_po_num;
		this.cm_ori_num = cm_ori_num;
		this.cm_content = cm_content;
		this.cm_me_id = cm_me_id;
	}
	public CommentVO(int cm_num, String cm_content) {
		this.cm_num = cm_num;
		this.cm_content = cm_content;
	}
}
