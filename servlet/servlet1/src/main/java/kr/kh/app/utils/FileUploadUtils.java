package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

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
	
	//uploadPath를 기준으로 paths 폴더들을 생성해주는 메소드
	//=> 한 폴더에 첨부파일을 다 업로드하면 서버 성능이 떨어지기 때문에 파일을 분산시키기 위해 폴더를 생성
	public static void makeDir(String uploadPath, String ... paths) {
		
		//2024, 2024/08, 2024/08/19
		int lastIndex = paths.length - 1;
		//마지막 폴더가 이미 존재하면 폴더를 만들 필요가 없음
		if(new File(uploadPath + paths[lastIndex]).exists()) {
			return;
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if(!dir.exists()) {
				dir.mkdir();
			}
		}
	}
	
	//uploadPath를 기준으로 년/월/일 폴더를 만들어서 경로를 반환하는 메소드
	public static String calculatePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		//년을 이용하여 \\2024 문자열 생성
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		
		//월을 이용하여 \\2024\\08 문자열 생성
		String monthPath = yearPath + File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		//일을 이용하여 \\2024\\08\\19 문자열 생성
		String dayPath = monthPath + File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, dayPath);
		//일을 이용하여 \\2024\\08\\19 문자열을 리턴
		return dayPath;
	}
	
	//첨부파일을 uploadPath에 업로드하는 메소드
	public static String upload(String uploadPath, Part file) {
		//첨부파일명을 가져옴
		String fileName = getFileName(file);
		//UUID를 생성. 8-4-4-4-12_파일명
		UUID uuid = UUID.randomUUID();
		String filePath = calculatePath(uploadPath) + File.separator + uuid + "_" + fileName; 
		
		//서버에 업로드
		try(InputStream is = file.getInputStream();
			OutputStream os = new FileOutputStream(uploadPath + filePath)){
			byte [] buffer = new byte[1024 * 4];
			int readCount = 0;
			while((readCount = is.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
			//\\2024\\08\\19\\uuid_파일명 => /2024/08/19/uuid_파일명으로 수정
			return filePath.replace(File.separatorChar, '/');
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
