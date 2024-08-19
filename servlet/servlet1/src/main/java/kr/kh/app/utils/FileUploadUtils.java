package kr.kh.app.utils;

import javax.servlet.http.Part;

public class FileUploadUtils {

	//Part 객체에서 파일명을 가져오는 메소드
	public static String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String [] items = contentDisposition.split(";");
		for(String item : items) {
			//속성명="값";
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		return null;
	}
}
