package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {

	private int fi_num; 
	private String fi_ori_name; 
	private String fi_name; 
	private int fi_po_num;

	public FileVO(int po_num, String fileName, String uploadFileName) {
		this.fi_po_num = po_num;
		this.fi_ori_name = fileName;
		this.fi_name = uploadFileName;
	}
}
