package kr.kh.spring3.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
    public static String uploadFile(String uploadPath, String originalName, byte[]
            fileData)throws Exception{
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() +"_" + originalName;
        String savedPath = calcPath(uploadPath);
        File target = new File(uploadPath + savedPath, savedName);
        FileCopyUtils.copy(fileData, target);
        String uploadFileName = getFileName(savedPath, savedName);
        return uploadFileName;
    }

    private static String calcPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();

        String yearPath = File.separator+cal.get(Calendar.YEAR);
        String monthPath = yearPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
        String datePath = monthPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
        makeDir(uploadPath, yearPath, monthPath, datePath);

        return datePath;

    }
    private static void makeDir(String uploadPath, String... paths) {
        if(new File(paths[paths.length-1]).exists())
            return;
        for(String path : paths) {
            File dirPath = new File(uploadPath + path);
            if( !dirPath.exists())
                dirPath.mkdir();
        }
    }
    private static String getFileName(String path, String fileName)
            throws Exception{
        String iconName = path + File.separator + fileName;
        return iconName.replace(File.separatorChar, '/');
    }
    public static void delteFile(String uploadPath, String fi_name) {
				fi_name = fi_name.replace('/', File.separatorChar);
				File file = new File(uploadPath + fi_name);
				//파일이 존재하면 파일을 삭제
				if(file.exists()) {
						file.delete();
				}
		}
}