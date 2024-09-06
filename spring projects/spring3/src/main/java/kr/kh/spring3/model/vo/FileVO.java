package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	int fi_num;
	String fi_name;
	String fi_ori_name;
	int fi_po_num;
	
	public FileVO(String fi_name, String fi_ori_name, int po_num) {
		this.fi_name = fi_name;
		this.fi_ori_name = fi_ori_name;
		this.fi_po_num = po_num;
	}
}
